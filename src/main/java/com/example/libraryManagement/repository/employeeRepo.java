package com.example.libraryManagement.repository;

import com.example.libraryManagement.models.employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface employeeRepo extends JpaRepository<employee,Integer> {


    employee findByName(String name);

}
