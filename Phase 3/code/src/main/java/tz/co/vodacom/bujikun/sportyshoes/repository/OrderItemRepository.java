package tz.co.vodacom.bujikun.sportyshoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tz.co.vodacom.bujikun.sportyshoes.entity.LineItem;

public interface OrderItemRepository extends JpaRepository<LineItem,Integer> {
}
