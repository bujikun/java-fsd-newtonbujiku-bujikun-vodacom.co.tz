package tz.co.vodacom.bujikun.sportyshoes.controller;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tz.co.vodacom.bujikun.sportyshoes.dto.ProductDTO;
import tz.co.vodacom.bujikun.sportyshoes.entity.Order;
import tz.co.vodacom.bujikun.sportyshoes.entity.OrderItem;
import tz.co.vodacom.bujikun.sportyshoes.security.CustomUserDetails;
import tz.co.vodacom.bujikun.sportyshoes.service.OrderItemService;
import tz.co.vodacom.bujikun.sportyshoes.service.OrderService;
import tz.co.vodacom.bujikun.sportyshoes.service.ProductService;
import tz.co.vodacom.bujikun.sportyshoes.service.UserService;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = {"/orders", "/orders/"})
public class OrderController {
    private final ProductService productService;
    private final OrderService orderService;
    private final OrderItemService orderItemService;

    @GetMapping
    public String index(Model model, Authentication authentication) {
        var userId = ((CustomUserDetails) authentication.getPrincipal()).getUser().getId();
        var myOrders = orderService.findAllOrdersByUserId(userId)
                .stream().map(o -> {
                    var totalPrice = o.getOrderItems().stream()
                                    .map(i->i.getTotalLinePrice())
                                            .reduce(new BigDecimal(0),(current,subtotal)->
                                                    subtotal.add(current));

                    o.setTotalPrice(totalPrice);
                    return o;
                }).collect(Collectors.toSet());
        model.addAttribute("orders", myOrders);
        return "order/index";
    }

    @GetMapping(value={"/view/{id}","/view/{id}/"})
    public String view(@PathVariable("id")Integer orderId, Model model, Authentication authentication) {
        var userId = ((CustomUserDetails) authentication.getPrincipal()).getUser().getId();
        var order = orderService.findOrderByUserIdAndOrderId(orderId,userId);
        var orderTotal = order.getOrderItems().stream()
                .map(i->i.getTotalLinePrice())
                .reduce(new BigDecimal(0),(current,subtotal)->
                        subtotal.add(current));;
        model.addAttribute("order", order);
        model.addAttribute("orderTotal", orderTotal);
        return "order/view";
    }

    @PostMapping("/payment")
    public String payment(@RequestParam("cart") String jsonString, @RequestParam("total") String total, Authentication authentication, Model model) {
        ProductDTO[] arr = new Gson().fromJson(jsonString, ProductDTO[].class);
        var loggedInUser = ((CustomUserDetails) authentication.getPrincipal()).getUser();
        //var user = userService.findByUsername(loggedInUser.getUsername());
        model.addAttribute("paymentNumber", loggedInUser.getPaymentAccountNumber());
        model.addAttribute("total", total);
        var order = new Order();
        order.setOrderItems(new HashSet<>());
        Arrays.stream(arr)
                .forEach(pdto -> {
                    var product = productService.findById(pdto.getId());
                    var orderItem = new OrderItem();
                    orderItem.setLineItemPrice(product.getPrice());
                    orderItem.setLineItemCount(pdto.getCount());
                    orderItem.setTotalLinePrice(product.getPrice().multiply(new BigDecimal(pdto.getCount())));
                    orderItem.setProductName(product.getName());
                    orderItemService.createNew(orderItem);
                    order.getOrderItems().add(orderItem);
                    order.setUser(loggedInUser);
                });
        orderService.createNew(order);
        return "order/payment";
    }
}
