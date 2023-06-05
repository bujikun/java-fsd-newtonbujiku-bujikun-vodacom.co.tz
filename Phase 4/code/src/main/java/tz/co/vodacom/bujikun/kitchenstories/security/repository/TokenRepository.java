package tz.co.vodacom.bujikun.kitchenstories.security.repository;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;
import tz.co.vodacom.bujikun.kitchenstories.entity.User;
import tz.co.vodacom.bujikun.kitchenstories.repository.BaseRepository;
import tz.co.vodacom.bujikun.kitchenstories.security.entity.Token;
import tz.co.vodacom.bujikun.kitchenstories.security.model.SecurityUserDetails;
import tz.co.vodacom.bujikun.kitchenstories.security.model.mapping.SecurityUserDetailsResultSetExtractor;

import java.util.Optional;

public interface TokenRepository extends BaseRepository<Token,Integer> {
    Token findTokenByValue(@Param("value") String value);
    Token findTokenByUsername(@Param("username") String username);
    @Modifying
    @Query("""
            UPDATE tokens
            SET invalidated = :invalidated, version = (version+1)
            WHERE username = :username;
            """)
    void invalidateUserTokens(String username,Boolean invalidated);
}
