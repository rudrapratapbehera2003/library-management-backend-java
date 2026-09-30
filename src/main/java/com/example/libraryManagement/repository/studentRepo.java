package com.example.libraryManagement.repository;

import com.example.libraryManagement.models.students;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface studentRepo extends JpaRepository<students,Integer> {

    @Query("SELECT s FROM students s WHERE s.rollNo = :rollNo")
    students findByRollNo(String rollNo);

    @Modifying
    @Transactional
    @Query("DELETE FROM students s WHERE s.rollNo = :rollNo")
    void deleteByRollNo(String rollNo);


    students findByName(String name);

}
