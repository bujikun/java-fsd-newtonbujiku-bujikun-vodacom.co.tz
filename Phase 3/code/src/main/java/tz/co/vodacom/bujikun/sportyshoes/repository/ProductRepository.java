package tz.co.vodacom.bujikun.sportyshoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tz.co.vodacom.bujikun.sportyshoes.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
