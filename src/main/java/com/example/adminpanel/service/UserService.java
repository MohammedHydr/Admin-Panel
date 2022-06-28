package com.example.adminpanel.service;

import com.example.adminpanel.entity.User;
import com.example.adminpanel.exceptions.NoSuchElementFoundException;
import com.example.adminpanel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserService {

    private final String SALT = "$2a$10$PMexcyhjmiGoQbobeQQCge";

    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<User> getAllUsers() throws NoSuchElementFoundException {
        return userRepository.findAll();
    }

    public void saveUser(User user){
        String hashPass = BCrypt.hashpw(user.getPassword(), SALT);
        user.setPassword(hashPass);
        userRepository.save(user);
    }

    public User getUserById(Long id){
        return userRepository.findById(id).get();
    }

    public void updateUser(User user){

        String hashPass = BCrypt.hashpw(user.getPassword(), SALT);
        user.setPassword(hashPass);
        userRepository.save(user);
    }

    public void deleteUserById(Long id){
        userRepository.deleteById(id);
    }


    public User getUser(User user){
        return userRepository.findByEmail(user.getEmail());
    }
}
