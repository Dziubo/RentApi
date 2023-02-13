package com.example.demo.user;

import com.example.demo.user.dto.UserAssignmentDto;
import com.example.demo.user.dto.UserCreateDto;
import com.example.demo.user.dto.UserDto;
import com.example.demo.user.mapper.UserAssignmentMapper;
import com.example.demo.user.mapper.UserCreateMapper;
import com.example.demo.user.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class UserService {
    private final UserRepository userRepository;
    UserService(UserRepository userRepository){
        this.userRepository = userRepository;

    }
    public List<UserDto> findUsersByLastname(String lastName){
        return userRepository.findAllByLastNameContaining(lastName).stream().map(UserMapper::toDto).collect(Collectors.toList())    ;
    }
    public UserDto createUser(UserCreateDto userDto){
        userRepository.findUserByPesel(userDto.getPesel()).ifPresent(x->{throw new UserPeselDuplicateException();});
        User user = UserCreateMapper.toEntity(userDto);
        User savedUser = userRepository.save(user);
        return UserMapper.toDto(savedUser);
    }


    public Optional<UserDto> findUserById(Long id){
        return (userRepository.findUserById(id).map(UserMapper::toDto));
    }
    @Transactional
    public UserDto updateUser(UserCreateDto userDto , Long id ){
        userRepository.findUserByPeselWhereIdIsDifferent(userDto.getPesel() , id)
                .ifPresent(x->{throw new UserPeselDuplicateException();});

        User savedUser = userRepository.save(UserCreateMapper.toEntity(userDto));
        return UserMapper.toDto(savedUser);
    }
    public List<UserAssignmentDto> getUsersAssignments(Long id){
        User user = userRepository.findUserById(id).orElseThrow(()->{throw new NoSuchElementException();});
            return user.getAssignments()
                    .stream()
                    .map(UserAssignmentMapper::toDto)
                    .collect(Collectors.toList());
        }
    }



