package tz.co.vodacom.bujikun.sportyshoes.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tz.co.vodacom.bujikun.sportyshoes.entity.User;
import tz.co.vodacom.bujikun.sportyshoes.exception.UserNotFoundException;
import tz.co.vodacom.bujikun.sportyshoes.repository.UserRepository;

import java.util.List;
@Service
@RequiredArgsConstructor
@Transactional
public class UserService implements GenericService<User,Integer>{
    private final UserRepository userRepository;
    @Override
    public void createNew(User user) {
        userRepository.save(user);
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
                .orElseThrow(()->new UserNotFoundException("User Not Found"));
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
