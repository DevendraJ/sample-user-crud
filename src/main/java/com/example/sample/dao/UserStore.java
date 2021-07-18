package com.example.sample.dao;

import com.example.sample.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserStore {
    public static List<User> users = new ArrayList<>();

    static {
        users.add(new User(1, "Bob", "Street 1", false));
        users.add(new User(2, "Philip", "Street 2", true));
        users.add(new User(3, "Jack", "Street 3", true));
        users.add(new User(4, "Ross", "Street 4", true));
        users.add(new User(5, "Herman", "Street 5", true));
    }
}
