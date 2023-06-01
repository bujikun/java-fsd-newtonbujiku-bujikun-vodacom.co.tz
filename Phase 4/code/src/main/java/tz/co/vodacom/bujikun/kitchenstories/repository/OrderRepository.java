package tz.co.vodacom.bujikun.kitchenstories.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import tz.co.vodacom.bujikun.kitchenstories.entity.Order;

public interface OrderRepository  extends PagingAndSortingRepository<Order,Integer> {

}
