package tz.co.vodacom.bujikun.kitchenstories.repository;

import org.springframework.data.jdbc.repository.query.Query;
import tz.co.vodacom.bujikun.kitchenstories.entity.User;
import tz.co.vodacom.bujikun.kitchenstories.security.model.SecurityUserDetails;
import tz.co.vodacom.bujikun.kitchenstories.security.model.mapping.SecurityUserDetailsResultSetExtractor;

import java.util.Optional;

public interface UserRepository extends BaseRepository<User,Integer> {
    Optional<User> findUserByUsername(String username);
}
