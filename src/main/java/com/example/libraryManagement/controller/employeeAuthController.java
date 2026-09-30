package com.example.libraryManagement.controller;

import com.example.libraryManagement.models.authentication;
import com.example.libraryManagement.models.employee;
import com.example.libraryManagement.services.employeeAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class employeeAuthController {

    @Autowired
    private employeeAuthService service;

    @PostMapping("/register")
    public ResponseEntity<?> employeeRegister(@RequestBody employee emp){
        try{
            employee emply = service.registerEmployee(emp);
            return new ResponseEntity<>(emply,HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> employeeLogin(@RequestBody authentication auth) {
        try {
            String token = service.verify(auth);
            return ResponseEntity.ok(token);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed: " + e.getMessage());
        }
    }

}
