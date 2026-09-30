package com.example.libraryManagement.repository;

import com.example.libraryManagement.models.rollNoVerification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface rollVerifyRepo extends JpaRepository<rollNoVerification,String> {

}
