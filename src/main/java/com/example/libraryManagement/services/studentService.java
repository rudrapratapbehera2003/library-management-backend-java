package com.example.libraryManagement.services;

import com.example.libraryManagement.models.Role;
import com.example.libraryManagement.models.rollNoVerification;
import com.example.libraryManagement.models.students;
import com.example.libraryManagement.repository.rollVerifyRepo;
import com.example.libraryManagement.repository.studentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class studentService {

    @Autowired
    private studentRepo studRepo;

    @Autowired
    private rollVerifyRepo rollRepo ;

    @Autowired
    PasswordEncoder encoder = new BCryptPasswordEncoder(12);


    public List<students> getStudents() {
        return studRepo.findAll();
    }

    public students getStudentByRollNo(String rollNo) {
        return studRepo.findByRollNo(rollNo);
    }

    public boolean isValidName(String name){
        if(name.length() <= 5){
            return false;
        }
        return true;
    }

    public void addStudent(students stud) {
        rollNoVerification rollVerify = rollRepo.findById(stud.getRollNo()).get();
        if(rollVerify == null){
            throw new IllegalArgumentException("There is no student with such roll number");
        } else if (rollVerify.isTaken() == true) {
            throw new IllegalArgumentException("The roll number is already been taken use another one");
        } else {
            rollVerify.setTaken(true);
            stud.setPassword(encoder.encode(stud.getPassword()));
            stud.setRole(Role.STUDENT);
            studRepo.save(stud);
        }
    }

    public void deleteStudent(String rollNo) {
        studRepo.deleteByRollNo(rollNo);
    }

    public void updateStudent(students stud) {
        studRepo.save(stud);
    }
}
