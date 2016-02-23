package com.infonal.dao;

import com.infonal.model.User;


import java.util.List;

// Person DAO Layer Interface
public interface IUserDAO {

    public User addUser(User person);

    public List<User> listUser();

    public void deleteUser(String userId);

    public User updateUser(String userId, String name, String surname, String telNumber);

    public User findById(String id);

}
