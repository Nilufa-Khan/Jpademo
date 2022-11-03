package com.example.Jpademo.service;

import com.example.Jpademo.domain.User;

import java.util.List;

public interface UserService {
    public User addUser(User user);
    public List<User> getUser();
    public User updateUser(User user, int userId);
    public boolean deleteUserById(int userId);
    public List<User> getUserByFirstName(String firstName);

}
