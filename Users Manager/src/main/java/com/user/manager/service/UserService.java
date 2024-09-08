package com.user.manager.service;


import com.user.manager.Dto.UserDto;
import com.user.manager.enums.Role;
import com.user.manager.model.User;
import com.user.manager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User addUser(UserDto userDto) {
        User user = new User();
        user.setUserName(userDto.getUserName());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        user.setRole(Role.USER);
        return userRepository.save(user);
    }

}
