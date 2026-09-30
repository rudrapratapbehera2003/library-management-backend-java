package com.example.libraryManagement.services;

import com.example.libraryManagement.models.books;
import com.example.libraryManagement.models.employee;
import com.example.libraryManagement.models.makeChit;
import com.example.libraryManagement.models.students;
import com.example.libraryManagement.repository.bookRepo;
import com.example.libraryManagement.repository.chitRepo;
import com.example.libraryManagement.repository.employeeRepo;
import com.example.libraryManagement.repository.studentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class chitService {

    @Autowired
    private chitRepo repoChit;
    @Autowired
    private studentRepo studRepo;
    @Autowired
    private bookRepo repoBook;
    @Autowired
    private employeeRepo repoEmp;


    public List<makeChit> getStudentChits(String name) {
        students stud = studRepo.findByName(name);
        if(stud == null){
             throw new IllegalArgumentException("student not found with name " + name);
        }
        List<makeChit> chits = repoChit.findByStudent(stud);
        chits.forEach(chit -> chit.setStudent(null));
        return chits;
    }

    public void addChits(String name, books book) {
        students stud = studRepo.findByName(name);
        if(stud == null){
            throw new IllegalArgumentException("Student not found with name " + name);
        }
        books bk = repoBook.findById(book.getId()).get();
        if(!bk.equals(book)) {
            throw new IllegalArgumentException("book does not found ");
        }
        makeChit chit = new makeChit();
        chit.setStudent(stud);
        chit.setBook(book);
        chit.setVerified(false);
        repoChit.save(chit);

    }

    public void removeChit(String name, int chitId) {
        employee emp = repoEmp.findByName(name);
        if(emp == null){
            throw new IllegalArgumentException("unauthorized, please check the credentials ");
        }
        makeChit chit = repoChit.findById(chitId).get();
        if(chit == null){
                throw new IllegalArgumentException("chit not found with id " +chitId);
        }
        repoChit.delete(chit);
    }
}
