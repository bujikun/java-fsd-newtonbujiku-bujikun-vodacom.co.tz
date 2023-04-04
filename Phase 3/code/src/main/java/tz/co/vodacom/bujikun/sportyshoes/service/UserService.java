package tz.co.vodacom.bujikun.sportyshoes.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tz.co.vodacom.bujikun.sportyshoes.entity.User;
import tz.co.vodacom.bujikun.sportyshoes.repository.UserRepository;

import java.util.List;
@Service
@RequiredArgsConstructor
@Transactional
public class UserService implements GenericService<User,Integer>{
    private final UserRepository userRepository;
    @Override
    public void createNew(User user) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public User findById(Integer id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }
}
