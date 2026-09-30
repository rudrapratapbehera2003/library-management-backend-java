package com.example.libraryManagement.models;


import jakarta.persistence.*;

@Entity
public class makeChit {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        @ManyToOne()
        @JoinColumn(name = "students_id",nullable = false)
        private students student;
        @ManyToOne
        @JoinColumn(name = "books_id",nullable = false)
        private books book;
        private boolean verified = false ;

        public makeChit(){

        }

    public makeChit(books book, int id, students student, boolean verified) {
        this.book = book;
        this.id = id;
        this.student = student;
        this.verified = verified;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public students getStudent() {
        return student;
    }

    public void setStudent(students student) {
        this.student = student;
    }

    public books getBook() {
        return book;
    }

    public void setBook(books book) {
        this.book = book;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    @Override
    public String toString() {
        return "makeChit{" +
                "id=" + id +
                ", student=" + student +
                ", book=" + book +
                ", verified=" + verified +
                '}';
    }
}
