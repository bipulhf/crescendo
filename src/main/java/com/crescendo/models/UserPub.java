package com.crescendo.models;

import java.io.Serializable;

public class UserPub implements Serializable {
    private int ID;
    private String name;
    private String email;
    private String role;
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public UserPub(){}

    public UserPub(int ID, String name, String email, String role) {
        this.ID = ID;
        this.name = name;
        this.email = email;
        this.role = role;
    }
}
