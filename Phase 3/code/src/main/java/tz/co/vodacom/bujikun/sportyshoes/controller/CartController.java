package tz.co.vodacom.bujikun.sportyshoes.controller;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tz.co.vodacom.bujikun.sportyshoes.dto.ProductDTO;
import tz.co.vodacom.bujikun.sportyshoes.service.ProductService;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = {"/cart", "/cart/"})
@RequiredArgsConstructor
public class CartController {
    private final ProductService productService;

    @PostMapping
    public String index(@RequestParam("cart") String jsonString, Model model) {
        ProductDTO[] arr = new Gson().fromJson(jsonString, ProductDTO[].class);
        var itemSet = Arrays.stream(arr)
                .map(pdto -> {
                    var product = productService.findById(pdto.getId());
                    if (product.getCount() < pdto.getCount()) {
                        //cart has more items than available, force the maximum
                        //you can buy all that is available
                        pdto.setCount(product.getCount());
                        //pdto.setPrice(product.getPrice());
                    }
                    pdto.setName(product.getName());
                    pdto.setPrice(product.getPrice().multiply(BigDecimal.valueOf(pdto.getCount())));
                    return pdto;
                })
                .collect(Collectors.toSet());
        var totalPrice = itemSet.stream()
                .map(p -> p.getPrice())
                .reduce(new BigDecimal(0), (big1, big2) -> big1.add(big2));
        //fetch products from db
        model.addAttribute("cartJson", jsonString);
        model.addAttribute("total", totalPrice);
        model.addAttribute("items", itemSet);
        //check if any of the counts if bigger than stock
        return "cart/index";
    }
}
