package com.example.demo.ulti;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncryptedPasswordUtil {
    public static String encryptedPassword(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }
}
