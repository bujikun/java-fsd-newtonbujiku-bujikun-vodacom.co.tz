package tz.co.vodacom.bujikun.sportyshoes.security;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import tz.co.vodacom.bujikun.sportyshoes.entity.User;

import java.util.Collection;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Getter
public class CustomUserDetails implements UserDetails {
    private final User user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return user.getRoles().stream()
                .flatMap(r -> r.getPermissions().stream()
                        .map(p -> new SimpleGrantedAuthority(p.getName())))
                .collect(Collectors.toSet());
    }

    @Override
    public String getPassword() {
        var pwd = user.getPassword();
        //user.setPassword(null);
        return pwd;
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return !user.getIsAccountExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return !user.getIsAccountLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !user.getIsCredentialsExpired();
    }

    @Override
    public boolean isEnabled() {
        return user.getIsEnabled();
    }

}
