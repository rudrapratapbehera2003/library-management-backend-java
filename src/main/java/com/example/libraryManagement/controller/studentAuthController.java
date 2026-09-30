package com.example.libraryManagement.controller;

import com.example.libraryManagement.models.authentication;
import com.example.libraryManagement.models.students;
import com.example.libraryManagement.services.studentAuthService;
import com.example.libraryManagement.services.studentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/student")
public class studentAuthController {

    @Autowired
    private studentAuthService service;

    @Autowired
    private studentService studService;


    @PostMapping("/register")
    public ResponseEntity<String> addStudent(@Valid @RequestBody students stud, BindingResult result){
        if(result.hasErrors()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result.getAllErrors().toString());
        }else if (!studService.isValidName(stud.getName())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please enter a valid name which should contain minimum 5 character");
        }
        studService.addStudent(stud);
        return ResponseEntity.status(HttpStatus.CREATED).body("student is successfully added.");
    }

    @PostMapping("/login")
    public ResponseEntity<?> studentLogin(@RequestBody authentication auth){
       try{
           String token = service.studentLogin(auth);
           return ResponseEntity.ok(token);
       }catch (Exception e){
           return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Failed to login");
       }
    }
}
