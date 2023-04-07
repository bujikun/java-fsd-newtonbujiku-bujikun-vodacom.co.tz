package tz.co.vodacom.bujikun.sportyshoes.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import tz.co.vodacom.bujikun.sportyshoes.repository.UserRepository;

@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .map(u->new CustomUserDetails(u))
                .orElseThrow(()-> new UsernameNotFoundException("Username Not Found"));
    }

}
