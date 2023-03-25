package tz.co.vodacom.bujikun.sportyshoes.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tz.co.vodacom.bujikun.sportyshoes.entity.Product;

import java.util.List;
@Service
@RequiredArgsConstructor
@Transactional
public class ProductService implements GenericService<Product,Integer> {
    @Override
    public void createNew(Product product) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void update(Product product) {

    }

    @Override
    public Product findById(Integer id) {
        return null;
    }

    @Override
    public List<Product> findAll() {
        return null;
    }
}
