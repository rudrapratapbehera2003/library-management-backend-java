package com.example.libraryManagement.services;

import com.example.libraryManagement.models.rollNoVerification;
import com.example.libraryManagement.repository.rollVerifyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class rollNoService {

    @Autowired
    private rollVerifyRepo rollRepo;

    public List<rollNoVerification> getRollNos() {
        return rollRepo.findAll();
    }

    public rollNoVerification addRollNo(rollNoVerification rollNo) {
        return rollRepo.save(rollNo);
    }

    public rollNoVerification getRollNoById(String str) {
        return rollRepo.getReferenceById(str);
    }

    public void deleteRoll(rollNoVerification rollNumber) {
        rollRepo.delete(rollNumber);
    }
}
