package tz.co.vodacom.bujikun.sportyshoes.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum RoleName {
    ADMIN("ADMIN"),
    USER("ADMIN"),
    SUPERADMIN("SUPERADMIN");
    private String value;
}
