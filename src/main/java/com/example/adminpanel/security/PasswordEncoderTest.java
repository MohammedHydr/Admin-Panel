package com.example.adminpanel.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderTest {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "moha2022";
        String encodedPassword = encoder.encode(rawPassword);
        System.out.println(encodedPassword);

    }

//    public static String trimEmail(String email){
//        int index = email.indexOf('@');
//        email = email.substring(0,index);
//        return email;
//    }

}
