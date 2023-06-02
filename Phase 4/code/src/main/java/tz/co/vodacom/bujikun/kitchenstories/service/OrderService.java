package tz.co.vodacom.bujikun.kitchenstories.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tz.co.vodacom.bujikun.kitchenstories.entity.Order;
import tz.co.vodacom.bujikun.kitchenstories.repository.OrderRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    public void save(Order order){
        orderRepository.save(order);
    }
}
