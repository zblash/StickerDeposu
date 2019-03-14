package com.stickerdeposu.web.Service.Concrete;

import com.stickerdeposu.web.Repositories.CartRepository;
import com.stickerdeposu.web.Repositories.RoleRepository;
import com.stickerdeposu.web.Repositories.UserRepository;
import com.stickerdeposu.web.Service.Abstract.IUserService;
import com.stickerdeposu.web.models.Cart;
import com.stickerdeposu.web.models.CartItem;
import com.stickerdeposu.web.models.Role;
import com.stickerdeposu.web.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private RoleRepository roleRepository;

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
        Role role = roleRepository.findByRoleName("ROLE_USER").orElse(new Role("ROLE_USER"));
        Cart cart = new Cart();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setCart(cart);
        user.addRole(role);

        roleRepository.save(role);
        cartRepository.save(cart);
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
