package com.shish.linksaver.service.impl;

import com.shish.linksaver.persistence.entity.UserEntity;
import com.shish.linksaver.persistence.repository.UserRepository;
import com.shish.linksaver.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity register(UserEntity user) {


        user.setPassword(user.getPassword());
        user.setEmail(user.getEmail());

        UserEntity registeredUser = userRepository.save(user);

        return registeredUser;
    }

    @Override
    public List<UserEntity> getAll() {
        List<UserEntity> result = userRepository.findAll();
        return result;
    }

    @Override
    public UserEntity findUserByEmail(String email) {

        UserEntity result = userRepository.findByEmail(email);
        return result;
    }

    @Override
    public UserEntity findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {

        userRepository.deleteById(id);
        log.info("User delete");
    }
}
