package com.stickerdeposu.web.Service.Abstract;

import com.stickerdeposu.web.models.User;

import java.util.List;

public interface IUserService {

    List<User> findAll();

    User findById(Long id);

    void Save(User user);

    void Delete(User user);

}
