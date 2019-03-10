package com.stickerdeposu.web.Service.Concrete;

import com.stickerdeposu.web.Repositories.UserRepository;
import com.stickerdeposu.web.Service.Abstract.IUserService;
import com.stickerdeposu.web.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public void Save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public void Delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName).orElseThrow(RuntimeException::new);
    }
}
