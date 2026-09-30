package com.example.libraryManagement.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @NotNull(message = "Name can not be null")
    String name;
    @NotNull(message = "please select the author name")
    String author;
    String publication;
    int year;
    String type;
    int numBooks;
    boolean available;

    public books() {

    }

    public books(int id, String name, String author, String publication, int year, String type, int numBooks, boolean available) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publication = publication;
        this.year = year;
        this.type = type;
        this.numBooks = numBooks;
        this.available = available;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public @NotNull(message = "Name can not be null") String getName() {
        return name;
    }

    public void setName(@NotNull(message = "Name can not be null") String name) {
        this.name = name;
    }

    public @NotNull(message = "please select the author name") String getAuthor() {
        return author;
    }

    public void setAuthor(@NotNull(message = "please select the author name") String author) {
        this.author = author;
    }

    public String getPublication() {
        return publication;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNumBooks() {
        return numBooks;
    }

    public void setNumBooks(int numBooks) {
        this.numBooks = numBooks;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "books{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", publication='" + publication + '\'' +
                ", year=" + year +
                ", type='" + type + '\'' +
                ", numBooks=" + numBooks +
                ", available=" + available +
                '}';
    }
}
