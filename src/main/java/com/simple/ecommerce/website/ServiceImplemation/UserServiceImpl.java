package com.simple.ecommerce.website.ServiceImplemation;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.simple.ecommerce.website.DTO.DtoMapper;
import com.simple.ecommerce.website.DTO.User.UserRegisterDTO;
import com.simple.ecommerce.website.DTO.User.UserResponseDTO;
import com.simple.ecommerce.website.Entity.User;
import com.simple.ecommerce.website.Repository.UserRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements com.simple.ecommerce.website.ServiceInterface.UserService {

    @Autowired
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder; // BCrypt bean

    @Override
    @Transactional
    public UserResponseDTO registerUser(UserRegisterDTO dto) {

       if (userRepository.findByUsername(dto.getUsername()).isPresent()) {
        throw new RuntimeException("Username already exists");
       }

       User u = User.builder()
       .username(dto.getUsername())
       .password(passwordEncoder.encode(dto.getPassword()))
       .build();

       return DtoMapper.toResponse(userRepository.save(u));


    }

    @Override
    @Transactional
    public UserResponseDTO getUserId(Integer UserId) {
        return userRepository.findById(UserId)
                .map(DtoMapper::toResponse)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public User getEntity(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

}
