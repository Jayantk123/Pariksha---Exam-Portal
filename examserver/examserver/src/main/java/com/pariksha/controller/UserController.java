package com.pariksha.controller;


import com.pariksha.helper.UserFoundException;
import com.pariksha.model.Role;
import com.pariksha.model.User;
import com.pariksha.model.UserRole;
import com.pariksha.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/test")
    public String test()
    {
        return "Welcome to backend api of pariksha";
    }

    //    creating user
@PostMapping("/")
    public User createUser(@RequestBody User user) throws Exception {

//    user.setProfile("default.png");

//    encoding password with bcryptencoder
    user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
        Set<UserRole> roles = new HashSet<>();
        Role role = new Role();
        role.setRoleId(45L);
        role.setRoleName("Normal");
        

        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);
        roles.add(userRole);
        return this.userService.createUser(user,roles);
    }

    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username)
    {
return this.userService.getUser(username);
    }

//    delete user by id
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId)
    {
this.userService.deleteUser(userId);
    }


    @GetMapping("/userid/{uId}")
    public User getUserbyId(@PathVariable("uId") Long uId)
    {
        return this.userService.getUserbyId(uId);
    }

//    @PutMapping("/")
//    public User updateUser(@RequestBody User user)
//    {
//
//        Set<UserRole> roles = new HashSet<>();
//        Role role = new Role();
//        role.setRoleId(45L);
//        role.setRoleName("Normal");
//
//        UserRole userRole = new UserRole();
//        userRole.setUser(user);
//        userRole.setRole(role);
//        roles.add(userRole);
//
//        return this.userService.updateUser(user,roles);
//    }

//    @ExceptionHandler(UserFoundException.class)
//    public ResponseEntity<?> exceptionHandler(UserFoundException)
//    {
//        return ResponseEntity<?> UserFoundException();

    }

