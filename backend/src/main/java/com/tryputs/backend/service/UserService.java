package com.tryputs.backend.service;

import com.tryputs.backend.dto.UserDto;
import com.tryputs.backend.mapper.UserMapper;
import com.tryputs.backend.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public void save(UserDto user) {
        userRepository.save(userMapper.toEntity(user));
    }
}
