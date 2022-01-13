package com.shish.linksaver.security.Jwt;

import com.shish.linksaver.persistence.entity.RolesEntity;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtTokenProvider {

    @Value("${jwt.token.secret}")
    private String secretKey ;

    @Value("${jwt.token.expired")
    private Long timeValidated ;

    public String createToken(String useremail, RolesEntity roles) {

        Claims claims = Jwts.claims().setSubject(useremail);
        claims.put("roles", roles.getRolename());

        Date now = new Date();
        Date validity = new Date(now.getTime() + timeValidated);

        return Jwts.builder()//
                .setClaims(claims)//
                .setIssuedAt(now)//
                .setExpiration(validity)//
                .signWith(SignatureAlgorithm.HS256, secretKey)//
                .compact();
    }
    public boolean validateToken(String token) {
        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);

            if (claims.getBody().getExpiration().before(new Date())) {
                return false;
            }

            return true;
        } catch (JwtException | IllegalArgumentException e) {
            throw new RuntimeException("JWT token is expired or invalid");
        }
    }
}
