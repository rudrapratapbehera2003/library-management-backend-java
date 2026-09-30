package com.example.libraryManagement.services;

import com.example.libraryManagement.models.books;
import com.example.libraryManagement.repository.bookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class bookService {

    @Autowired
    private bookRepo bookRepo;

    public List<books> getListBooks() {
        return bookRepo.findAll();
    }

    public void addBook(books book) {
        bookRepo.save(book);
    }
}
