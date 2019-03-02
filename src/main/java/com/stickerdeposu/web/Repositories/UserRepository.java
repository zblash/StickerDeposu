package com.stickerdeposu.web.Repositories;


import com.stickerdeposu.web.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
