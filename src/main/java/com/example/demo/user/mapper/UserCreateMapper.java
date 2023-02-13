package com.example.demo.user.mapper;

import com.example.demo.user.User;
import com.example.demo.user.dto.UserCreateDto;

public class UserCreateMapper {
    public static User  toEntity(UserCreateDto userDto){
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPesel(userDto.getPesel());
        return user;
    }
}
