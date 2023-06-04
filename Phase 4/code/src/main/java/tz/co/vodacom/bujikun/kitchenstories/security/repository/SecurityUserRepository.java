package tz.co.vodacom.bujikun.kitchenstories.security.repository;

import org.springframework.data.jdbc.repository.query.Query;
import tz.co.vodacom.bujikun.kitchenstories.entity.User;
import tz.co.vodacom.bujikun.kitchenstories.repository.BaseRepository;
import tz.co.vodacom.bujikun.kitchenstories.security.model.SecurityUserDetails;
import tz.co.vodacom.bujikun.kitchenstories.security.model.mapping.SecurityUserDetailsResultSetExtractor;

import java.util.Optional;

public interface SecurityUserRepository extends BaseRepository<User,Integer> {
    @Query(value = """
            SELECT username,
                   password,
                   is_account_expired,
                   is_account_locked,
                   is_credentials_expired,
                   is_enabled,
                   p.name as permission_name
            FROM users
                     JOIN users_permissions up ON users.id = up.fk_user_id
                     JOIN permissions p ON up.fk_permission_id = p.id
            WHERE users.username = :username;
            """, resultSetExtractorClass = SecurityUserDetailsResultSetExtractor.class)
    Optional<SecurityUserDetails> loadUserByUsername(String username);
}
