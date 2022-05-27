package com.example.adminpanel.android;

import com.example.adminpanel.entity.User;
import com.example.adminpanel.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j(topic = "PRODUCT_CONTROLLER")
@RestController
public class AndroidController {
    @Autowired
    private UserService userService;

    @GetMapping("/user/get-all")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
}
