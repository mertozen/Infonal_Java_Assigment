package com.infonal.service;

import com.infonal.model.User;

import java.util.ArrayList;
import java.util.List;

public interface IUserService {

    public User addUser(User user);

    public List<User> listUser();

    public void deleteUser(String userId);

    public User updateUser(String userId, String name, String surname, String telNumber);

    public User findById(String userId);

}