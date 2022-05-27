package com.example.adminpanel.controller;

import com.example.adminpanel.entity.Admin;
import com.example.adminpanel.service.AdminService;
import com.example.adminpanel.service.PlaceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j(topic = "PRODUCT_CONTROLLER")
@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private PlaceService placeService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @RequestMapping("/")
    public String index() {
        return "redirect:/login";
    }

    // Login form
    @RequestMapping("/login")
    public String login() {
        return "admin/login";
    }


    @RequestMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "admin/login";
    }

    // Login form
    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("listP", placeService.getAllPlaces());
        return "index";
    }

    //register form
    @GetMapping("/register")
    public String showSignUpForm(Model model){
        Admin admin = new Admin();
        model.addAttribute("admin", admin);
        return "admin/register";
    }

    // save regigter
    @PostMapping("/register")
    public String processRegistration(Admin admin){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(admin.getPassword());
        admin.setPassword(encodedPassword);

        adminService.saveAdmin(admin);
        return "admin/login";
    }
    // view admins
    @GetMapping("/list_admin")
    public String viewAdminList(Model model){
        model.addAttribute("listAdmins", adminService.getAllAdmins());
        return "admin/admins";
    }

}
