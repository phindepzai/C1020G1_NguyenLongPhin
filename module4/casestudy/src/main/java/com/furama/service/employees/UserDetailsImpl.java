package com.furama.service.employees;

import com.furama.entity.employee.User;
import com.furama.entity.employee.UserRole;
import com.furama.repository.employee.UserRepository;
import com.furama.repository.employee.UserRoleRepository;
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
        System.out.println(s);
        User user = userRepository.findByUsername(s);
        if (user == null) {
            System.out.println("User not found! " + s);
            throw new UsernameNotFoundException("User " + s + " was not found in the database");
        }
        System.out.println("Found User: " + user.getUsername());
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
