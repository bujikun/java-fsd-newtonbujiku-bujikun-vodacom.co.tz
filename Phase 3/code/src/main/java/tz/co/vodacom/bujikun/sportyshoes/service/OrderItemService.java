package tz.co.vodacom.bujikun.sportyshoes.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tz.co.vodacom.bujikun.sportyshoes.entity.LineItem;
import tz.co.vodacom.bujikun.sportyshoes.repository.OrderItemRepository;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderItemService implements GenericService<LineItem, Integer> {

    private final OrderItemRepository orderItemRepository;

    @Override
    public void createNew(LineItem lineItem) {
        orderItemRepository.save(lineItem);
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void update(LineItem lineItem) {

    }

    @Override
    public LineItem findById(Integer id) {
        return orderItemRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Order Item Not Found"));
    }

    @Override
    public List<LineItem> findAll() {
        return orderItemRepository.findAll();
    }
}
