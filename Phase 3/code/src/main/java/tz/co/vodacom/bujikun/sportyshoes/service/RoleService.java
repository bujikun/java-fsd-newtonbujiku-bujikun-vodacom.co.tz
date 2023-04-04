package tz.co.vodacom.bujikun.sportyshoes.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tz.co.vodacom.bujikun.sportyshoes.entity.Role;
import tz.co.vodacom.bujikun.sportyshoes.exception.RoleNotFoundException;
import tz.co.vodacom.bujikun.sportyshoes.repository.RoleRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class RoleService implements GenericService<Role,Integer>{
    private final RoleRepository roleRepository;
    @Override
    public void createNew(Role role) {
        roleRepository.save(role);
    }

    @Override
    public void delete(Integer id) {
        var fromDB = findById(id);
        roleRepository.delete(fromDB);
    }

    @Override
    public void update(Role role) {

    }

    @Override
    public Role findById(Integer id) {
        return roleRepository.findById(id)
                .orElseThrow(()->new RoleNotFoundException("Role Not Found"));
    }
    public Role findByName(String name) {
        return roleRepository.findByName(name)
                .orElseThrow(()->new RoleNotFoundException("Role Not Found"));
    }
    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }
}
