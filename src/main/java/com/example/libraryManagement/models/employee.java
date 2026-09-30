package com.example.libraryManagement.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class employee {
    @Id
   private int id;
    @NotNull(message = "Name should not be empty")
    @Column(unique = true)
   private String name;
    @NotNull(message = "Id should not be empty")
   private String idNum;
    @Column(unique = true)
    @NotNull(message = "this field is required")
   private String password;
    @Enumerated(EnumType.STRING)
    private Role role;

    public employee(){

    }

    public employee(int id, String name, String idNum, String password, Role role) {
        this.id = id;
        this.name = name;
        this.idNum = idNum;
        this.password = password;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public @NotNull(message = "Name should not be empty") String getName() {
        return name;
    }

    public void setName(@NotNull(message = "Name should not be empty") String name) {
        this.name = name;
    }

    public @NotNull(message = "Id should not be empty") String getIdNum() {
        return idNum;
    }

    public void setIdNum(@NotNull(message = "Id should not be empty") String idNum) {
        this.idNum = idNum;
    }

    public @NotNull(message = "this field is required") String getPassword() {
        return password;
    }

    public void setPassword(@NotNull(message = "this field is required") String password) {
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
        return "employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", idNum='" + idNum + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
