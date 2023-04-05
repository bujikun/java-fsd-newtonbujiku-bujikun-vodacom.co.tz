package tz.co.vodacom.bujikun.sportyshoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tz.co.vodacom.bujikun.sportyshoes.entity.Order;
import tz.co.vodacom.bujikun.sportyshoes.entity.OrderItem;

import java.util.List;
import java.util.Optional;

public interface OrderItemRepository extends JpaRepository<OrderItem,Integer> {
}
