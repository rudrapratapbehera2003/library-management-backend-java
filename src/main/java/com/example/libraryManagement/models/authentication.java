package com.example.libraryManagement.models;

import jakarta.validation.constraints.NotNull;

public class authentication {
    @NotNull(message = "Username should not be null")
    private String name;
    @NotNull(message = "password should not be null")
    private String password;

    public authentication(){

    }

    public authentication(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public @NotNull(message = "Username should not be null") String getName() {
        return name;
    }

    public void setName(@NotNull(message = "Username should not be null") String name) {
        this.name = name;
    }

    public @NotNull(message = "password should not be null") String getPassword() {
        return password;
    }

    public void setPassword(@NotNull(message = "password should not be null") String password) {
        this.password = password;
    }
}
