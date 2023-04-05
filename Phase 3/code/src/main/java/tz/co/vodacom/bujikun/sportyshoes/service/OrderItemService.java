package tz.co.vodacom.bujikun.sportyshoes.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tz.co.vodacom.bujikun.sportyshoes.entity.Order;
import tz.co.vodacom.bujikun.sportyshoes.entity.OrderItem;
import tz.co.vodacom.bujikun.sportyshoes.exception.OrderNotFoundException;
import tz.co.vodacom.bujikun.sportyshoes.repository.OrderItemRepository;
import tz.co.vodacom.bujikun.sportyshoes.repository.OrderRepository;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderItemService implements GenericService<OrderItem, Integer> {

    private final OrderItemRepository orderItemRepository;

    @Override
    public void createNew(OrderItem orderItem) {
        orderItemRepository.save(orderItem);
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void update(OrderItem orderItem) {

    }

    @Override
    public OrderItem findById(Integer id) {
        return orderItemRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Order Item Not Found"));
    }

    @Override
    public List<OrderItem> findAll() {
        return orderItemRepository.findAll();
    }
}
