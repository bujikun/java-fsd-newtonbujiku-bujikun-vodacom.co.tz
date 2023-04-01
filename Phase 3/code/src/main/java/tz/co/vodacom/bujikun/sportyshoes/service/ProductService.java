package tz.co.vodacom.bujikun.sportyshoes.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tz.co.vodacom.bujikun.sportyshoes.entity.Product;
import tz.co.vodacom.bujikun.sportyshoes.exception.ProductNotFoundException;
import tz.co.vodacom.bujikun.sportyshoes.repository.ProductRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductService implements GenericService<Product, Integer> {
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
        var fromDB = findById(product.getId());
        fromDB.setUpdatedOn(LocalDateTime.now());
        fromDB.setName(product.getName());
        fromDB.setPrice(product.getPrice());
        fromDB.setCount(product.getCount());
        fromDB.setDescription(product.getDescription());
        productRepository.save(fromDB);
    }

    @Override
    public Product findById(Integer id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product Not Found"));
    }

    @Override
    public List<Product> findAll() {
        var all = productRepository.findAll();
       return all.stream()
                .map(p -> {
                    var categoryString = "Fit For: " + p.getCategories().stream().map(c -> c.getName()).collect(Collectors.joining(" , "));
                    p.setCategoryString(categoryString);
                    return p;
                }).toList();
    }
}
