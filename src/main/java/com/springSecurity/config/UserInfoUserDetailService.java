package com.springSecurity.config;

import com.springSecurity.entity.UserInfo;
import com.springSecurity.repositoty.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserInfoUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserInfo> userInfo =  userRepo.findByUsername(username);

        return userInfo.map(UserInfoConvUserDetails::new)
                .orElseThrow(()->new UsernameNotFoundException("user not found "+username));

    }
}
