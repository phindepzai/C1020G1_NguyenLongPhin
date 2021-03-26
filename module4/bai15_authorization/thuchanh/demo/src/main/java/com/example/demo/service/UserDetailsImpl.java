package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.entity.UserRole;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findById(s).orElse(null);
        if (user == null) {
            System.out.println("User not found! " + s);
            throw new UsernameNotFoundException("User " + s + " was not found in the database");
        }
        System.out.println("Found User: " + user);
        List<UserRole> userRoles = userRoleRepository.findAllByUser(user);
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        if (userRoles != null) {
            for (UserRole userRole : userRoles) {
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(userRole.getRole().getName());
                grantedAuthorities.add(grantedAuthority);
            }
        }
        return (UserDetails) new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }
}
