package com.example.adminpanel.controller;

import com.example.adminpanel.entity.User;
import com.example.adminpanel.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j(topic = "PRODUCT_CONTROLLER")
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // handler method to handle list users amd return model and view
    @GetMapping("/users")
    public String listUsers(Model model){
        //keys and values , access this key using thymeleaf syntax ${listPlaces}
        model.addAttribute("listUsers", userService.getAllUsers());
        return "user/users"; // name of the html file
    }

    @GetMapping("/users/new")
    public String createUserForm(Model model){
        // create user object to hold user from data
        User user = new User();
        model.addAttribute("addUser",user);
        return "user/create_user";
    }

    @PostMapping("/users")
    public String saveUser(@ModelAttribute("users") User user){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(); //encode the password
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/users/edit/{id}")
    public String editUserForm(@PathVariable Long id, Model model){
        model.addAttribute("editUser", userService.getUserById(id));
        return "user/edit_user";
    }

    @PostMapping("/users/{id}")
    public String updateUser(@PathVariable Long id, @ModelAttribute("updateUser") User user){
        //get user from database by id
        User existingUser = userService.getUserById(id);
        existingUser.setId(id);
        existingUser.setUserName(user.getUserName());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());

        // save updated student object
        userService.updateUser(existingUser);
        return "redirect:/users";
    }

    //handler method to handle delete user request
    @GetMapping("/users/{id}")
    public String deleteUser(@PathVariable Long id){
        userService.deleteUserById(id);
        return "redirect:/users";
    }

}
