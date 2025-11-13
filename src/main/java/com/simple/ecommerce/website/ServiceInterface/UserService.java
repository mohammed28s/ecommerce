package com.simple.ecommerce.website.ServiceInterface;

import com.simple.ecommerce.website.DTO.User.UserRegisterDTO;
import com.simple.ecommerce.website.DTO.User.UserResponseDTO;
import com.simple.ecommerce.website.Entity.User;

public interface UserService {

  
   UserResponseDTO registerUser(UserRegisterDTO user); // Creating new user

   UserResponseDTO getUserId(Integer userId); // get user by id

   User getEntity(Integer id); // helper for internal use
}
