package com.scaler.factory;

import com.scaler.model.User;

public class Userfactory {
    public static User createUser(String userName, boolean isAdmin) {
        return new User(userName, isAdmin);
    }
}
