package com.example.demo.user;

import com.example.demo.user.dto.UserAssignmentDto;
import com.example.demo.user.dto.UserDto;
import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


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
    public ResponseEntity<UserDto>save(@RequestBody @Valid UserDto userDto ){
        if (userDto.getId()!=null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "użytkownik przy tworzeniu nie może zawierac id");
        UserDto user = userService.createUser(userDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(location).body(user);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id ){
        return userService.findUserById(id).map(ResponseEntity::ok)
                .orElseThrow(()->{throw new ResponseStatusException(HttpStatus.NOT_FOUND , "użytkownik o podanym id nie istnieje");});
    }
    @PutMapping("/{id}")
    public ResponseEntity<UserDto> update(@Valid @RequestBody UserDto userDto, @PathVariable Long id ){
        if (id.equals(userDto.getId())) {
            UserDto userDto1 = userService.updateUser(userDto);
            return ResponseEntity.ok(userDto1);
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST , "id danego użytkownika musi się zgadzac z id ze sciezki zasobu");
    }
    @GetMapping("{userId}/assignments")
    public List<UserAssignmentDto> getAssignmentsOfUser(@PathVariable Long userId){
        return  userService.getUsersAssignments(userId);
    }
}
