package com.example.adminpanel.service;

import com.example.adminpanel.entity.Admin;
import com.example.adminpanel.exceptions.NoSuchElementFoundException;
import com.example.adminpanel.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public List<Admin> getAllAdmins() throws NoSuchElementFoundException {
        return adminRepository.findAll();
    }

    public void saveAdmin(Admin admin){
        adminRepository.save(admin);
    }
}
