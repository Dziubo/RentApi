package com.example.demo.user;

import com.example.demo.user.dto.UserAssignmentDto;
import com.example.demo.user.dto.UserCreateDto;
import com.example.demo.user.dto.UserDto;
import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.NoSuchElementException;


@RequestMapping("/api/users")
@RestController
public class UserController {
    private final UserService  userService;
    UserController(UserService userService){
        this.userService = userService;
    }
    @GetMapping()
    public List<UserDto> findAll(@RequestParam(defaultValue = "") String lastName){
        return userService.findUsersByLastname(lastName);
    }
    @PostMapping
    public ResponseEntity<UserDto>save(@RequestBody @Valid UserCreateDto userDto ){
        UserDto user = userService.createUser(userDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(location).body(user);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id ){
        return userService.findUserById(id).map(ResponseEntity::ok)
                .orElseThrow(NoSuchElementException::new);};
    @PutMapping("/{id}")
    public ResponseEntity<UserDto> update(@Valid @RequestBody UserCreateDto userDto, @PathVariable Long id ){
                UserDto userDto1 = userService.updateUser(userDto , id) ;
            return ResponseEntity.ok(userDto1);
        }

    @GetMapping("{userId}/assignments")
    public List<UserAssignmentDto> getAssignmentsOfUser(@PathVariable Long userId){
        return  userService.getUsersAssignments(userId);
    }
}
