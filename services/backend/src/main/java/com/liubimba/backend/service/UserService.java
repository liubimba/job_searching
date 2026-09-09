package com.liubimba.backend.service;


import com.liubimba.backend.dto.UserDTO;
import com.liubimba.backend.entity.UserEntity;
import com.liubimba.backend.exception.UserMailExistsException;
import com.liubimba.backend.mapper.UserMapper;
import com.liubimba.backend.repository.UserRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {
    UserRepository userRepository;
    UserMapper userMapper;

    @Autowired
    UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserEntity register(UserDTO dto) throws UserMailExistsException {
        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new UserMailExistsException("Email address already registered");
        }
        return userRepository.save(userMapper.toEntity(dto));
    }
}
