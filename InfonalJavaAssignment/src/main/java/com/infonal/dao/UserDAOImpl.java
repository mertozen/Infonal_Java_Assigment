package com.infonal.dao;

import com.infonal.config.SpringMongoConfig;
import com.infonal.model.User;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;


@Repository
public class UserDAOImpl implements IUserDAO {

    // log4j implementation
   private static final Logger logger = Logger.getLogger(UserDAOImpl.class);

    ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
    MongoOperations mongoTemplate = (MongoOperations) ctx.getBean("mongoTemplate");

    // mongoDB database collection for personal information
    public static final String COLLECTION_NAME = "users";

    // for adding new user document to mongodb
    @Override
    public User addUser(User user) {

        try {

            if(user !=null) {

                if (!mongoTemplate.collectionExists(User.class)) {
                    mongoTemplate.createCollection(User.class);
                }

                mongoTemplate.insert(user, COLLECTION_NAME);
            }else {

                System.out.println(" process isn't success !");

            }

        }catch (Exception ex){

             ex.printStackTrace();

        }

        // logging
        //logger.info("person added");
        return user;

    }

    // to get all user list from mongodb
    @Override
    public List<User> listUser() {
        return mongoTemplate.findAll(User.class, COLLECTION_NAME);
    }

    // delete user document
    @Override
    public void deleteUser(String userId) {

        try {

            User prs = findById(userId);
            mongoTemplate.remove(prs, COLLECTION_NAME);

            logger.info("user document is deleted");

        }catch (Exception ex){

            ex.printStackTrace();
            logger.info("deleteUser function is fail");
        }


    }

    // update user document
    @Override
    public User updateUser(String userId, String name, String surname, String phoneNumber) {

try {

    DBCollection clc = mongoTemplate.getCollection(COLLECTION_NAME);
    BasicDBObject dbo = new BasicDBObject();
    BasicDBObject query = new BasicDBObject("_id", userId);
    dbo.put("name", name);
    dbo.put("surname", surname);
    dbo.put("phoneNumber",phoneNumber );

    BasicDBObject updateObj = new BasicDBObject();
    updateObj.put("users", dbo);
    clc.update(query, (DBObject) updateObj.get("users"), false, false);
    logger.info("User is updated");

}catch (Exception ex){

    ex.printStackTrace();

    logger.info("Update function is fail");

}
        return null;

    }

    // find user by user id. Used for delete person
    @Override
    public User findById(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        logger.info("findById is executed");
        return mongoTemplate.findOne(query, User.class, COLLECTION_NAME);
    }

}
