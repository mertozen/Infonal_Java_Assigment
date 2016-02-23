package com.infonal.service;

import com.infonal.dao.IUserDAO;
import com.infonal.model.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mert on 2/22/16.
 */
@Service
public class UserServiceImpl implements IUserService {


    //ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
    //MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
    @Autowired
    IUserDAO userDAO;

// log4j implementation
    private static final Logger logger = Logger.getLogger(UserServiceImpl.class);

    // mongoDB database template
    //@Autowired
    //private MongoTemplate mongoTemplate;

    // mongoDB database collection for personal information
    public static final String COLLECTION_NAME = "users";

    public User addUser(User user) {
       userDAO.addUser(user);
        return user;
    }

    public List<User> listUser() {

     List<User> users = userDAO.listUser();
        return users;
    }


    public void deleteUser(String userId) {

       userDAO.deleteUser(userId);
    }

    public User updateUser(String userId, String name, String surname, String phoneNumber) {

        return this.userDAO.updateUser(userId, name, surname,phoneNumber);
    }

    public User findById(String id) {

      User user =  userDAO.findById(id);
        return user;

    }
}
