package tz.co.vodacom.bujikun.kitchenstories.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tz.co.vodacom.bujikun.kitchenstories.dto.OrderDTO;
import tz.co.vodacom.bujikun.kitchenstories.entity.Order;
import tz.co.vodacom.bujikun.kitchenstories.repository.CustomerRepository;
import tz.co.vodacom.bujikun.kitchenstories.repository.OrderRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    public void save(OrderDTO orderDTO){
        var customer = customerRepository.save(orderDTO.getCustomerDTO().toCustomer());
        var order = orderDTO.toOrder();
        order.setCustomerId(customer.getId());
        order.setCreatedOn(LocalDateTime.now());
        order.setVersion(1);
        orderRepository.save(order);
    }

    public List<OrderDTO> findAll(){
       var  orders = (List<Order>) orderRepository.findAll();
      return orders.stream()
               .map(o->OrderDTO.fromOrder(o))
               .toList();
    }
}
