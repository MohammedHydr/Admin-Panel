package com.example.adminpanel.android;

import com.example.adminpanel.entity.Category;
import com.example.adminpanel.entity.User;
import com.example.adminpanel.service.CategoryService;
import com.example.adminpanel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AndroidController {
    @Autowired
    private UserService userService;

    @Autowired
    private CategoryService categoryService;


    @RequestMapping(value = "/api/users/getUser", method = RequestMethod.POST)
    public User getUser(@RequestBody User user){
        return userService.getUser(user);
    }

    @RequestMapping(value = "/api/users/saveUser", method = RequestMethod.POST)
    public void save(@RequestBody User user){
         userService.saveUser(user);
    }

    @RequestMapping(value = "/api/users/getAllUsers", method = RequestMethod.GET)
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/api/users/getAllCategories", method = RequestMethod.GET)
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }
}
