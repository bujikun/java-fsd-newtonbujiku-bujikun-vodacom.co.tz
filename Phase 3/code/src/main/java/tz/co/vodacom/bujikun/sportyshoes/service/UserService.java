package tz.co.vodacom.bujikun.sportyshoes.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tz.co.vodacom.bujikun.sportyshoes.entity.User;
import tz.co.vodacom.bujikun.sportyshoes.exception.UserNotFoundException;
import tz.co.vodacom.bujikun.sportyshoes.exception.UsernameExiststException;
import tz.co.vodacom.bujikun.sportyshoes.repository.RoleRepository;
import tz.co.vodacom.bujikun.sportyshoes.repository.UserRepository;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService implements GenericService<User, Integer> {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleService  roleService;

    public User findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("User Not Found!"));
    }

    @Override
    public void createNew(User user) {

    }

    public User registerUser(String username, String password) {
        User user;
        //check if user exists
        try{
            user  = findByUsername(username);
            //user exists, fail
            throw new UsernameExiststException("Username already in use!");
        }catch (UserNotFoundException e){
            //user exists, do nothing but proceed with registration
        }

        user = User.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .isEnabled(true)
                .isAccountLocked(false)
                .isCredentialsExpired(false)
                .isAccountExpired(false)
                .roles(Set.of(roleService.findByName("USER")))
                .build();
        return userRepository.save(user);
    }

    @Override
    public void delete(Integer id) {
        var fromDB = findById(id);
        userRepository.delete(fromDB);
    }

    @Override
    public void update(User user) {
        //map values
    }

    @Override
    public User findById(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User Not Found"));
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
