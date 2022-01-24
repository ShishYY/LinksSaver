package com.shish.linksaver.security.Jwt;

import com.shish.linksaver.persistence.entity.RolesEntity;
import com.shish.linksaver.persistence.entity.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public final class JwtUserFactory {

    public static JWTUser create(UserEntity user){
        return new JWTUser(
                user.getId(),
                user.getEmail(),
                user.getPassword(),
                mapToGrantedAuthorities(user.getRole())

        );
    }

        private static List<GrantedAuthority> mapToGrantedAuthorities(RolesEntity role) {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(role.getRolename()));
            return grantedAuthorities;
        }
}

