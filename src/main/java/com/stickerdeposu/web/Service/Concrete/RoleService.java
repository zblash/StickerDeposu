package com.stickerdeposu.web.Service.Concrete;

import com.stickerdeposu.web.Repositories.RoleRepository;
import com.stickerdeposu.web.Service.Abstract.IRoleService;
import com.stickerdeposu.web.models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleService implements IRoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role findById(Long id) {
        return roleRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public void Save(Role role) {
        roleRepository.save(role);
    }

    @Override
    public void Delete(Role role) {
        roleRepository.delete(role);
    }

    @Override
    public Role findByName(String role) {
        return roleRepository.findByRoleName(role).orElseThrow(RuntimeException::new);
    }
}
