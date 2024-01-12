package com.exam.service;

import java.util.Set;

import com.exam.model.User;
import com.exam.model.UserRole;

public interface UserService {

    // create user
    public User createUser(User user, Set<UserRole> userRole) throws Exception;

    //get user
    public User getUser(String username);

    //delete user
    public void deleteUser(Long id);

}
