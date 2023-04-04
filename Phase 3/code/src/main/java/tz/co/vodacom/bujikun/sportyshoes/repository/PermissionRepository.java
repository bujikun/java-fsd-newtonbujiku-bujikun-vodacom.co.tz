package tz.co.vodacom.bujikun.sportyshoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tz.co.vodacom.bujikun.sportyshoes.entity.Permission;

import java.util.Optional;

public interface PermissionRepository extends JpaRepository<Permission,Integer> {
    @Query("SELECT p FROM Permission  p WHERE p.name=:name")
    Optional<Permission> findByName(String name);
}
