package com.shish.linksaver.service;

import com.shish.linksaver.persistence.entity.UserEntity;
import com.shish.linksaver.persistence.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public interface UserService {

     UserEntity register(UserEntity user);

     List<UserEntity> getAll();

      UserEntity findUserByEmail(String email);

      UserEntity findById(Long id);

      void delete(Long id);
}


