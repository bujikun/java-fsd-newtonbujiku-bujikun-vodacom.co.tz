package tz.co.vodacom.bujikun.sportyshoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tz.co.vodacom.bujikun.sportyshoes.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository  extends JpaRepository<User,Integer> {
    @Query("SELECT u FROM User  u WHERE u.username = :username")
    Optional<User> findByUsername(String username);
    @Query("FROM User u WHERE u.username LIKE(:query) OR u.email LIKE(:query) OR u.city LIKE(:query) " +
            "ORDER BY u.createdOn DESC ")
    List<User> searchUser(String query);
    @Query("FROM User u ORDER BY u.createdOn DESC")
    List<User> findAll();
}

