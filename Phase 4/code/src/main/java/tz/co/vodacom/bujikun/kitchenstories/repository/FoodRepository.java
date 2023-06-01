package tz.co.vodacom.bujikun.kitchenstories.repository;

import org.springframework.data.jdbc.repository.query.Query;
import tz.co.vodacom.bujikun.kitchenstories.entity.Food;

import java.util.List;

public interface FoodRepository extends BaseRepository <Food,Integer> {
    @Query("SELECT  * FROM foods")
    List<Food> findAll();
    @Query("SELECT * FROM foods  f WHERE f.name LIKE '%':name'%'")
    List<Food> searchByName(String name);
}
