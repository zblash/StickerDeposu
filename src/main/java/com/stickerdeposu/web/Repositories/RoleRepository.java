package com.stickerdeposu.web.Repositories;

import com.stickerdeposu.web.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {

    Optional<Role> findByRoleName(String roleName);

}
