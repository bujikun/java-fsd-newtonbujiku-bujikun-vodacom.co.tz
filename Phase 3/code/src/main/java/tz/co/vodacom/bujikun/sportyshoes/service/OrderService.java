package tz.co.vodacom.bujikun.sportyshoes.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tz.co.vodacom.bujikun.sportyshoes.entity.Order;
import tz.co.vodacom.bujikun.sportyshoes.exception.OrderNotFoundException;
import tz.co.vodacom.bujikun.sportyshoes.repository.OrderRepository;
import tz.co.vodacom.bujikun.sportyshoes.util.Util;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService implements GenericService<Order, Integer> {

    private final OrderRepository orderRepository;

    @Override
    public void createNew(Order order) {
        orderRepository.save(order);
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void update(Order order) {

    }

    @Override
    public Order findById(Integer id) {
        return orderRepository.findById(id)
                .orElseThrow(()-> new OrderNotFoundException("Order Not Found"));
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order findOrderByUserId(Integer id){
        return orderRepository.findOrderByUserId(id)
                .orElseThrow(()-> new OrderNotFoundException("Order Not Found"));
    }

    public Order findOrderByUserIdAndOrderId(Integer orderId, Integer userId){
        var order =  orderRepository.findOrderByUserIdAndOrderId(orderId,userId)
                .orElseThrow(()-> new OrderNotFoundException("Order Not Found"));
//        var totalPrice = order.getOrderItems().stream()
//                .map(i->i.getTotalLinePrice())
//                .reduce(new BigDecimal(0),(current,subtotal)->
//                        subtotal.add(current));
//        order.setTotalPrice(totalPrice);
        return order;
    }
    public List<Order> findAllOrdersByUserId(Integer id){
        return orderRepository.findAllOrdersByUserId(id);
//                .stream().map(o -> {
//            var totalPrice = o.getOrderItems().stream()
//                    .map(i->i.getTotalLinePrice())
//                    .reduce(new BigDecimal(0),(current, subtotal)->
//                            subtotal.add(current));
//
//            o.setTotalPrice(totalPrice);
//            return o;
//        }).toList();
    }
}
