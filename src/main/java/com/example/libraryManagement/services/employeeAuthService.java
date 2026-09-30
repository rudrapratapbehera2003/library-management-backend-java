package com.example.libraryManagement.services;

import com.example.libraryManagement.models.Role;
import com.example.libraryManagement.models.authentication;
import com.example.libraryManagement.models.employee;
import com.example.libraryManagement.repository.employeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class employeeAuthService {

    @Autowired
    private employeeRepo repo;

    @Autowired
    private AuthenticationManager authManager;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public employee registerEmployee(employee emp) {
            emp.setPassword(encoder.encode(emp.getPassword()));
            emp.setRole(Role.EMPLOYEE);
            return repo.save(emp);
    }


    public String verify(authentication auth) {
        Authentication authenticate = authManager.authenticate(new UsernamePasswordAuthenticationToken(auth.getName(),auth.getPassword()));
        if(authenticate.isAuthenticated()){
            SecurityContextHolder.getContext().setAuthentication(authenticate);
            return JwtService.generateToken(auth.getName(),Role.EMPLOYEE);
        }
        return "fail";
    }
}
