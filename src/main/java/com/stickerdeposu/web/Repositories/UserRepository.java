package com.stickerdeposu.web.Repositories;


import com.stickerdeposu.web.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByUserName(String userName);
}
