package com.example.libraryManagement.controller;

import com.example.libraryManagement.models.rollNoVerification;
import com.example.libraryManagement.services.rollNoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class rollNoController {

    @Autowired
    private rollNoService rollService;

    @GetMapping("/studentsRoll")
    public List<rollNoVerification> getRollNos(){
        return rollService.getRollNos();
    }

    @PostMapping("/studentsRoll")
    public ResponseEntity<?> addRollNos(@RequestBody rollNoVerification rollNo){
            try{
                rollNoVerification studRoll = rollService.addRollNo(rollNo);
                return new ResponseEntity<>(studRoll, HttpStatus.CREATED);
            }catch (Exception e){
                return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
            }
    }
    @DeleteMapping("/studentsRoll/{str}")
    public ResponseEntity<String> deleteRoll(@PathVariable String str){
        rollNoVerification rollNumber = rollService.getRollNoById(str);
           if(rollNumber != null){
               rollService.deleteRoll(rollNumber);
               return new ResponseEntity<>("Roll number is deleted successfully ",HttpStatus.OK);
           }else{
               return new ResponseEntity<>("Roll number does not found",HttpStatus.NOT_FOUND);
           }
    }

}
