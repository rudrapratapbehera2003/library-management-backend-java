package com.example.libraryManagement.models;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;



@Entity
public class rollNoVerification {

    @Id
    String rollNo;
    boolean taken = false;

    public rollNoVerification(){

    }

    public rollNoVerification(String rollNo, boolean taken) {
        this.rollNo = rollNo;
        this.taken = taken;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public boolean isTaken() {
        return taken;
    }

    public void setTaken(boolean taken) {
        this.taken = taken;
    }

    @Override
    public String toString() {
        return "rollNoVerification{" +
                "rollNo='" + rollNo + '\'' +
                ", taken=" + taken +
                '}';
    }
}
