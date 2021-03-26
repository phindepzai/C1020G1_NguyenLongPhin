package com.example.demo.ulti;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class WebUtils {
    public static String toString(User user) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Username : ").append(user.getUsername());
        Collection<GrantedAuthority> grantedAuthorities = user.getAuthorities();
        if (grantedAuthorities != null && !grantedAuthorities.isEmpty()) {
            stringBuilder.append(" (");
            boolean first = true;
            for (GrantedAuthority granted : grantedAuthorities) {
                if (first) {
                    stringBuilder.append(granted.getAuthority());
                    first = false;
                } else {
                    stringBuilder.append(",").append(granted.getAuthority());
                }
            }
            stringBuilder.append(")");
        }
        return stringBuilder.toString();
    }
}
