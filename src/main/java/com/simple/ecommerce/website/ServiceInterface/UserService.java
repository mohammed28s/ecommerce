package com.simple.ecommerce.website.ServiceInterface;

import java.util.List;

import com.simple.ecommerce.website.Entity.User;

public interface UserService {

    List<User> getAllUsers();  // get all users

    User getUserById(Integer UserId);  // get user by id

    User saveUser(User user);  // create new user

    void deleteUser(Integer userId); // delete user by id

    User updateUser(Integer userId, User user);  // update exstitng user info

}
