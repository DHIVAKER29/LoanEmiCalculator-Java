package com.scaler.service;

import com.scaler.model.User;

import java.util.HashMap;
import java.util.Map;

public class UserService {
    private static UserService instance;
    private Map<String, User> users;

    private UserService() {
        users = new HashMap<String, User>();
    }

    public static synchronized UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }
    public void createUser(String username, boolean isAdmin) {
        if(!users.containsKey(username)) {
            users.put(username, new User(username, isAdmin));
            System.out.println("User created: " + username + " " + isAdmin);
        }
        else{
            System.out.println("User already exists: " + username + " " + isAdmin);
        }
    }
    public User getUser(String username) {
        return users.get(username);
    }
}
