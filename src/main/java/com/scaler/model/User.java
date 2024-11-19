package com.scaler.model;


public class User {
    private String userName;
    private boolean isAdmin;

    public User(String userName, boolean isAdmin) {
        this.isAdmin = isAdmin;
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public boolean isAdmin() {
        return isAdmin;
    }
}
