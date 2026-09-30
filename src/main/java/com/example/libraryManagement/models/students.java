package com.example.libraryManagement.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.aspectj.bridge.Message;
import org.springframework.stereotype.Component;


@Component
@Entity
public class students {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
    @NotNull(message = "username cannot be empty and should be unique")
    @Column(unique = true)
   private String name;
    @NotNull(message = "please select a valid roll. Roll no should be unique")
    @Column(unique = true)
   private String rollNo;
    @NotNull(message = "password should not be null")
   private String password;
    @Enumerated(EnumType.STRING)
    private Role role;

    public students(){

    }

    public students(int id, String name, String rollNo, String password, Role role) {
        this.id = id;
        this.name = name;
        this.rollNo = rollNo;
        this.password = password;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public @NotNull(message = "username cannot be empty and should be unique") String getName() {
        return name;
    }

    public void setName(@NotNull(message = "username cannot be empty and should be unique") String name) {
        this.name = name;
    }

    public @NotNull(message = "please select a valid roll. Roll no should be unique") String getRollNo() {
        return rollNo;
    }

    public void setRollNo(@NotNull(message = "please select a valid roll. Roll no should be unique") String rollNo) {
        this.rollNo = rollNo;
    }

    public @NotNull(message = "password should not be null") String getPassword() {
        return password;
    }

    public void setPassword(@NotNull(message = "password should not be null") String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "students{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rollNo='" + rollNo + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
