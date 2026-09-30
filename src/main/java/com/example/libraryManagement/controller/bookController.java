package com.example.libraryManagement.controller;

import com.example.libraryManagement.models.books;
import com.example.libraryManagement.services.bookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class bookController {

    @Autowired
    private bookService bookservice;

    @RequestMapping("/access/books")
    public List<books> getBooks(){
        return bookservice.getListBooks();
    }
    @PostMapping("/books")
    public ResponseEntity<String> addBook(@Valid @RequestBody books book){
        bookservice.addBook(book);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Book is added successfully");
    }
}
