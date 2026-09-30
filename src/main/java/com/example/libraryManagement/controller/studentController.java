package com.example.libraryManagement.controller;

import com.example.libraryManagement.models.students;
import com.example.libraryManagement.services.studentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class studentController {

    @Autowired
    private studentService studService;

    @RequestMapping("/students")
    public List<students> getStudents(){
        return studService.getStudents();
    }
    @RequestMapping("/students/{rollNo}")
    public students getStudentByRollNo(@PathVariable String rollNo){
        return studService.getStudentByRollNo(rollNo);
    }

    @PutMapping("/students")
    public ResponseEntity<String> updateStudent(@RequestBody students stud){
        studService.updateStudent(stud);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Student is updated successfully");
    }

    @DeleteMapping("/students/{rollNo}")
    public ResponseEntity<String> deleteStudent(@PathVariable String rollNo){
        studService.deleteStudent(rollNo);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("student deleted successfully");
    }
}
