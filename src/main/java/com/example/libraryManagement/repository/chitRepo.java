package com.example.libraryManagement.repository;

import com.example.libraryManagement.models.books;
import com.example.libraryManagement.models.makeChit;
import com.example.libraryManagement.models.students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface chitRepo extends JpaRepository<makeChit,Integer> {

   List<makeChit> findByStudent(students stud);

 }
