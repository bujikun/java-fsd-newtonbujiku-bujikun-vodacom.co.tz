package tz.co.vodacom.bujikun.sportyshoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tz.co.vodacom.bujikun.sportyshoes.entity.Order;
import tz.co.vodacom.bujikun.sportyshoes.entity.User;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order,Integer> {
    @Query("SELECT o FROM Order  o WHERE o.user.id = :userId AND o.id= :orderId")
    Optional<Order> findOrderByUserIdAndOrderId(Integer orderId, Integer userId);
    @Query("SELECT o FROM Order  o WHERE o.user.id = :id")
    Optional<Order> findOrderByUserId(Integer id);
    @Query("FROM Order o WHERE o.user.id = :id ORDER BY o.createdOn")
    List<Order> findAllOrdersByUserId(Integer id);
}
