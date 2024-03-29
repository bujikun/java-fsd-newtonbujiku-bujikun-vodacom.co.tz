package tz.co.vodacom.bujikun.kitchenstories.security.model.mapping;

import lombok.NoArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import tz.co.vodacom.bujikun.kitchenstories.security.model.SecurityUserDetails;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
public class SecurityUserDetailsResultSetExtractor implements ResultSetExtractor<SecurityUserDetails> {
    @Override
    public SecurityUserDetails extractData(ResultSet rs) throws SQLException, DataAccessException {
        SecurityUserDetails securityUserDetails = null;
        Set<String> permissionNames = new HashSet<>();
        while (rs.next()) {
            if (rs.isFirst()) {
                securityUserDetails = new SecurityUserDetails(
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getBoolean("is_account_locked"),
                        rs.getBoolean("is_account_expired"),
                        rs.getBoolean("is_credentials_expired"),
                        rs.getBoolean("is_enabled"),
                        permissionNames
                );
            }
            securityUserDetails.getPermissionNames().add(rs.getString("permission_name"));
        }
        return securityUserDetails;
    }
}
