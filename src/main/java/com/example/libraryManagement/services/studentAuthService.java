package com.example.libraryManagement.services;

import com.example.libraryManagement.models.Role;
import com.example.libraryManagement.models.authentication;
import com.example.libraryManagement.models.students;
import com.example.libraryManagement.repository.rollVerifyRepo;
import com.example.libraryManagement.repository.studentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class studentAuthService {

    @Autowired
    private studentRepo studRepo;

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JwtService jwtService;



    public String studentLogin(authentication auth) {
        Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(auth.getName(),auth.getPassword()));
        if(authentication.isAuthenticated()){
            return jwtService.generateToken(auth.getName(), Role.STUDENT);
        }
        return "failed to login: check the credentials";
    }
}
