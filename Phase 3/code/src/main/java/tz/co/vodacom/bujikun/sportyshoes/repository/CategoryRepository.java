package tz.co.vodacom.bujikun.sportyshoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tz.co.vodacom.bujikun.sportyshoes.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository  extends JpaRepository<Category,Integer> {
    @Query("SELECT c FROM Category  c WHERE c.id = :id AND c.deleted = 0 ")
    Optional<Category> findActiveById(Integer id);

    @Query("FROM Category  WHERE deleted = 0  ")
    List<Category> findAllActive();
}
