package tz.co.vodacom.bujikun.sportyshoes.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import tz.co.vodacom.bujikun.sportyshoes.entity.User;
import tz.co.vodacom.bujikun.sportyshoes.service.UserService;

@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    private static UserDetails entityToUserDetails(User user){
        return null;
    }
}
