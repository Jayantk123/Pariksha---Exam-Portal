package com.pariksha.service.impl;

import com.pariksha.helper.UserFoundException;
import com.pariksha.model.User;
import com.pariksha.model.UserRole;
import com.pariksha.repo.RoleRepository;
import com.pariksha.repo.UserRepository;
import com.pariksha.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

//    creating user
    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {


User local = this.userRepository.findByUsername(user.getUsername());

if(local!=null)
{
    System.out.println("User already exist.");
    throw new UserFoundException();
}
else
{
//    create and save user
    for(UserRole ur:userRoles)
    {
        roleRepository.save(ur.getRole());
    }
    user.getUserRoles().addAll(userRoles);
    local=this.userRepository.save(user);
}
        return local;
    }

//    get user by username
    @Override
    public User getUser(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public void deleteUser(Long userId) {
        this.userRepository.deleteById(userId);
    }

    @Override
    public User updateUser(User user, Set<UserRole> userRoles) {
        User local = this.userRepository.findByUsername(user.getUsername());

        if(local!=null)
        {
            System.out.println("User already exist.");

        }
        else
        {
//    create and save user
            for(UserRole ur:userRoles)
            {
                roleRepository.save(ur.getRole());
            }
            user.getUserRoles().addAll(userRoles);
            local=this.userRepository.save(user);
        }
        return local;
    }




    @Override
    public User getUserbyId(Long userId) {
        return this.userRepository.findById(userId).get();
    }

//    @Override
//    public User updateUser(User user) {
//
//        Long idv=user.getId();
//        boolean existf = userRepository.existsById(idv);
//
//        if(!existf)
//        {
//            throw new IllegalStateException(idv+"not exist");
//        }
//
//        userRepository.save(user);
//        return user;
//    }
}
