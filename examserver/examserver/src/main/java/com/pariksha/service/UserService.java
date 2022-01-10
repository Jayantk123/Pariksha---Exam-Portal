package com.pariksha.service;

import com.pariksha.model.User;
import com.pariksha.model.UserRole;

import java.util.Set;

public interface UserService {

//    for creating user
    public User createUser(User user, Set<UserRole> userRoles) throws Exception;

//    get user by username
    public User getUser(String username);

//    delete by id
    public void deleteUser(Long userId);


//    User updateUser(User user);
    public User updateUser(User user,Set<UserRole> userRoles);

//    get user by userid
    public User getUserbyId(Long userId);

}
