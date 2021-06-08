package com.youle.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author MaRui
 * @date 2021-06-07 17:25
 */
public class Test {
    public static void main(String[] args) {
        String pass = "admin";
        BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();
        String hashPass = bcryptPasswordEncoder.encode(pass);
        System.out.println(hashPass);

        boolean f = bcryptPasswordEncoder.matches("admin",hashPass);
        System.out.println(f);
    }
}

