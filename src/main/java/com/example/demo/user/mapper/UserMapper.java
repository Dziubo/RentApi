package com.example.demo.user.mapper;

import com.example.demo.user.User;
import com.example.demo.user.dto.UserDto;

public class UserMapper {
    public static UserDto toDto(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setPesel(user.getPesel());
        return userDto;
    }
    public static User toEntity(UserDto userDto){
        User user = new User();
        user.setId(userDto.getId());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPesel(userDto.getPesel());
        return user;
    }
}
