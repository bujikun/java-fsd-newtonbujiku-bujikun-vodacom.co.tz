package tz.co.vodacom.bujikun.sportyshoes.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tz.co.vodacom.bujikun.sportyshoes.entity.User;
import tz.co.vodacom.bujikun.sportyshoes.exception.UserNotFoundException;
import tz.co.vodacom.bujikun.sportyshoes.exception.UsernameExiststException;
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
        //check if user exists
        try{
            findByUsername(user.getUsername());
            //user exists, fail
            throw new UsernameExiststException("Username already in use!",user);
        }catch (UserNotFoundException e){
            //user exists, do nothing but proceed with registration
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setIsAccountExpired(false);
        user.setIsAccountLocked(false);
        user.setIsCredentialsExpired(false);
        user.setIsEnabled(true);
        user.setRoles(Set.of(roleService.findByName("USER")));
         userRepository.save(user);
    }

    public List<User> search(String query){
      return userRepository.searchUser("%"+query+"%");
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

    public void makeAdmin(Integer userID) {
        var user = findById(userID);
        var adminRole = roleService.findByName("ADMIN");
        user.getRoles().add(adminRole);
        userRepository.save(user);
    }
    public void revokeAdmin(Integer userID) {
        var user = findById(userID);
        var adminRole = roleService.findByName("ADMIN");
        user.getRoles().remove(adminRole);
        userRepository.save(user);
    }

    public boolean isPasswordUpdated(String currentPassword, String newPassword,
                                  Integer userId) {
        var user = findById(userId);
       //check if valid current password was supplied
        //if matches the password in the db
        if(passwordEncoder.matches(currentPassword,user.getPassword())){
            //fine then update it
            user.setPassword(passwordEncoder.encode(newPassword));
            return true;
        }
        return false;//password change failed
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
