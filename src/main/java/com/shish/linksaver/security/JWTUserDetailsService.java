package com.shish.linksaver.security;

import com.shish.linksaver.persistence.entity.UserEntity;
import com.shish.linksaver.security.Jwt.JwtUserFactory;
import com.shish.linksaver.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class JWTUserDetailsService implements UserDetailsService {

    private final UserService userService;

    public JWTUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {

        UserEntity user = userService.findUserByEmail(userEmail);

        if (user == null){
            throw new UsernameNotFoundException("User with email " + userEmail + "not found");
        }

        return JwtUserFactory.create(user);
    }
}
