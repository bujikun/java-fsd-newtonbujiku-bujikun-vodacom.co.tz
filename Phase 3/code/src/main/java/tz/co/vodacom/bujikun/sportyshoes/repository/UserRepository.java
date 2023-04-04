package tz.co.vodacom.bujikun.sportyshoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tz.co.vodacom.bujikun.sportyshoes.entity.User;

import java.util.Optional;

public interface UserRepository  extends JpaRepository<User,Integer> {
    @Query("SELECT u FROM User  u WHERE u.username = :username")
    Optional<User> findByUsername(String username);
}
