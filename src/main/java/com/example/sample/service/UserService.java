package com.example.sample.service;

import com.example.sample.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.sample.dao.UserStore.users;

@Service
public class UserService {

    public List<User> getAllUsers() {
        return users;
    }

    public List<User> getActiveUsers() {
        return users.stream()
                .filter(user -> user.isActive())
                .collect(Collectors.toList());
    }

    public User getUser(Integer userId) {
        return users
                .stream()
                .filter(user -> user.getId() == userId)
                .findFirst()
                .orElse(null);
    }

    public void saveUser(User newUser) throws Exception {
        String userName = newUser.getUserName();
        if (userName == null || userName.trim().length() == 0) {
            throw new Exception("User name cannot be empty");
        }

        boolean alreadyExists = users
                .stream()
                .anyMatch(user -> user.getId() == newUser.getId());
        if (alreadyExists) {
            throw new Exception("User already exists.");
        }

        users.add(newUser);
    }

    public void updateUser(Integer userid, User userToUpdate) throws Exception {
        User user = null;
        for (User u : users) {
            if (u.getId() == userid) {
                user = u;
            }
        }

        if (user == null) {
            users.add(userToUpdate);
        } else {
            user.setUserName(userToUpdate.getUserName());
            user.setAddress(userToUpdate.getAddress());
            user.setActive(userToUpdate.isActive());
        }
    }
}
