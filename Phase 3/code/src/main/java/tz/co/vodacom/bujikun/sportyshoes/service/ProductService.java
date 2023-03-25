package tz.co.vodacom.bujikun.sportyshoes.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tz.co.vodacom.bujikun.sportyshoes.entity.Product;
import tz.co.vodacom.bujikun.sportyshoes.exception.ProductNotFoundException;
import tz.co.vodacom.bujikun.sportyshoes.repository.ProductRepository;

import java.util.List;
@Service
@RequiredArgsConstructor
@Transactional
public class ProductService implements GenericService<Product,Integer> {
    private final ProductRepository productRepository;
    @Override
    public void createNew(Product product) {
        productRepository.save(product);
    }

    @Override
    public void delete(Integer id) {
        productRepository.delete(findById(id));
    }

    @Override
    public void update(Product product) {

    }

    @Override
    public Product findById(Integer id) {
        return productRepository.findById(id)
                .orElseThrow(()-> new ProductNotFoundException("Product Not Found"));
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
