package com.example.adminpanel.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/")
    public String index(Model model) {
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
    public String index() {
        return "index";
    }

    @GetMapping("/register")
    public String showSignUpForm(Model model){
        Admin admin = new Admin();
        model.addAttribute("admin", admin);
        return "admin/register";
    }

    @PostMapping("/register")
    public String processRegistration(Admin admin){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(admin.getPassword());
        admin.setPassword(encodedPassword);

        adminService.saveAdmin(admin);
        return "admin/login";
    }

    @GetMapping("/list_admin")
    public String viewAdminList(Model model){
        model.addAttribute("listAdmins", adminService.getAllAdmins());
        return "admin/admins";
    }

}
