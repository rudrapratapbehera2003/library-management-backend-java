package com.example.libraryManagement.controller;

import com.example.libraryManagement.models.books;
import com.example.libraryManagement.models.makeChit;
import com.example.libraryManagement.services.chitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chits")
public class chitController {

    @Autowired
    private chitService service;

    @RequestMapping("/{name}")
    public ResponseEntity<?> getStudentChits(@PathVariable String name){
        try{
            List<makeChit> chits = service.getStudentChits(name);
            return ResponseEntity.ok(chits);
        }catch (Exception e){
            return ResponseEntity.status(500).body("Error in getting chits " + e.getMessage());
        }

    }

    @PostMapping("/add/{name}")
    public ResponseEntity<String> addChits(@PathVariable String name, @RequestBody books book){
        try{
            service.addChits(name,book);
            return ResponseEntity.ok("Chit added successfully");
        }catch (Exception e){
            return ResponseEntity.status(500).body("Failed to add chit :" + e.getMessage());
        }
    }

    @DeleteMapping("/remove/{name}/{chitId}")
    public ResponseEntity<String> removeChit(@PathVariable String name, @PathVariable int chitId){
            try{
                service.removeChit(name,chitId);
                return ResponseEntity.ok("The chit is deleted successfully");
            }catch(Exception e){
                return ResponseEntity.status(500).body("Couldn't remove the chit :" + e.getMessage());
            }
    }

}
