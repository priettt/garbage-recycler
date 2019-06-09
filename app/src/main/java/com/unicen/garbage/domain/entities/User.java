package com.unicen.garbage.domain.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("lastName")
    @Expose
    private String lastName;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("mail")
    @Expose
    private String mail;

    public String getFirstName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return mail;
    }

    public String getUsername() {
        return username;
    }

    public String getAddress() {
        return address;
    }

    public User(String firstName, String lastName, String email, String username, String address) {
        this.name = firstName;
        this.lastName = lastName;
        this.mail = email;
        this.username = username;
        this.address = address;
    }
}
