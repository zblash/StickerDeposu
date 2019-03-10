package com.stickerdeposu.web.Security;

import com.stickerdeposu.web.Service.Concrete.UserService;
import com.stickerdeposu.web.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserDetailsServiceImp implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        try{
            User user = userService.findByUserName(s);
            if (user == null) {
                throw new UsernameNotFoundException("User not found");
            }
            return new CustomPrincipal(user);

        }catch (Exception e){
            throw new UsernameNotFoundException("User not found");
        }
    }

}
