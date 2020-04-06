package com.tryputs.backend.mapper;

import com.tryputs.backend.dto.UserDto;
import com.tryputs.backend.entity.ApplicationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapper extends AbstractMapper<ApplicationUser, UserDto> {

    @Autowired
    public UserMapper() {
        super(ApplicationUser.class, UserDto.class);
    }
}
