package com.example.sample.model;

public class User {
    private int id;
    private String userName;
    private String address;
    private boolean isActive = true;

    public User(int id, String userName, String address, boolean isActive) {
        this.id = id;
        this.userName = userName;
        this.address = address;
        this.isActive = isActive;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
