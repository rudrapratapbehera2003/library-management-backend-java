package com.example.libraryManagement.repository;

import com.example.libraryManagement.models.books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface bookRepo extends JpaRepository<books,Integer> {


}
