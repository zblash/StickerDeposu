package com.stickerdeposu.web.Service.Abstract;

import com.stickerdeposu.web.models.Role;

import java.util.List;

public interface IRoleService {

    List<Role> findAll();

    Role findById(Long id);

    void Save(Role role);

    void Delete(Role role);

    Role findByName(String role_user);
}
