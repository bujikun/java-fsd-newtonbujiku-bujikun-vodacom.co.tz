package tz.co.vodacom.bujikun.sportyshoes.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tz.co.vodacom.bujikun.sportyshoes.entity.Permission;
import tz.co.vodacom.bujikun.sportyshoes.exception.PermissionNotFoundException;
import tz.co.vodacom.bujikun.sportyshoes.repository.PermissionRepository;

import java.util.List;
@Service
@RequiredArgsConstructor
@Transactional
public class PermissionService implements GenericService<Permission,Integer>{
    private final PermissionRepository permissionRepository;
    @Override
    public void createNew(Permission permission) {
        permissionRepository.save(permission);
    }

    @Override
    public void delete(Integer id) {
        var fromDB = findById(id);
        permissionRepository.delete(fromDB);
    }

    @Override
    public void update(Permission permission) {

    }

    @Override
    public Permission findById(Integer id) {
        return permissionRepository.findById(id)
                .orElseThrow(()-> new PermissionNotFoundException("permission not Found"));
    }

    @Override
    public List<Permission> findAll() {
        return permissionRepository.findAll();
    }
}
