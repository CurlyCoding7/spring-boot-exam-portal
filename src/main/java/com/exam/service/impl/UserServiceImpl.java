package com.exam.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.repo.RoleRepo;
import com.exam.repo.UserRepo;
import com.exam.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Override
    public User createUser(User user, Set<UserRole> userRole) throws Exception {

        User currUser = this.userRepo.findByUsername(user.getUsername());

        if(currUser != null){
            System.out.println("User already exist!");
            throw new Exception("User already exist!!!");
        }
        else{
            // create user
            for(UserRole ur : userRole){
                roleRepo.save(ur.getRole());
            }

            user.getUserRole().addAll(userRole);
            currUser = this.userRepo.save(user);
        }
        return currUser;
    }

    @Override
    public User getUser(String username) {
        return this.userRepo.findByUsername(username);
    }

    @Override
    public void deleteUser(Long id) {
        this.userRepo.deleteById(id);
    }

}
