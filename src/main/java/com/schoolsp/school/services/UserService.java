package com.schoolsp.school.services;

import com.schoolsp.school.dto.UserDTO;
import com.schoolsp.school.models.User;
import com.schoolsp.school.repositories.UserRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;

    UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @PreAuthorize("hasRole('USER')")
    public List<UserDTO> getAllUsers(){
        List<UserDTO> userDTOS = new ArrayList<>();
        List<User> users = userRepository.findAll();
        for(User user: users){
            userDTOS.add(new UserDTO(
                    user.getUsername(),
                    user.getEmail(),
                    user.getPassword(),
                    user.getRoles()
            ));
        }
        return userDTOS;
    }
}
