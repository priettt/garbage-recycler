package com.unicen.garbage.domain.entities;

public class User {
    private String address;
    private String firstName;
    private String lastName;
    private String email;
    private String username;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getAddress() {
        return address;
    }

    public User(String firstName, String lastName, String email, String username, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.address = address;
    }
}
