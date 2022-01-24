package com.shish.linksaver.controler;

import com.shish.linksaver.model.dto.AuthenticationRequestDto;
import com.shish.linksaver.persistence.entity.UserEntity;
import com.shish.linksaver.security.Jwt.JwtTokenProvider;
import com.shish.linksaver.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/auth/")
    public class AutentificationController {

        private final AuthenticationManager authenticationManager;

        private final JwtTokenProvider jwtTokenProvider;

        private final UserService userService;

        public AutentificationController(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider, UserService userService) {
            this.authenticationManager = authenticationManager;
            this.jwtTokenProvider = jwtTokenProvider;
            this.userService = userService;
        }

        @PostMapping(value = "login",consumes = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity login(@RequestBody AuthenticationRequestDto requestDto) {
            try {
                String username = requestDto.getUsername();
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, requestDto.getPassword()));
                UserEntity user = userService.findUserByEmail(username);

                if (user == null) {
                    throw new UsernameNotFoundException("User with username: " + username + " not found");
                }

                String token = jwtTokenProvider.createToken(username, user.getRole().getRolename());

                Map<Object, Object> response = new HashMap<>();
                response.put("email", username);
                response.put("token", token);

                return ResponseEntity.ok(response);
            } catch (AuthenticationException e) {
                throw new BadCredentialsException("Invalid username or password");
            }
        }
}
