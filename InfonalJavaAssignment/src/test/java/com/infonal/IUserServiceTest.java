package com.infonal;

import com.infonal.dao.IUserDAO;
import com.infonal.model.User;
import com.infonal.service.IUserService;
import com.infonal.service.UserServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.UUID;


/**
 * Created by mert on 2/21/16.
 */


public class IUserServiceTest {


    @Mock
    private IUserDAO userDAO;

    @InjectMocks
    private UserServiceImpl userService;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }



@Test
public void addUserTest (){


    User user = new User();
    user.setId("2dsadsadasdasdadadaasda");
    user.setSurname("deneme1");
    user.setName("deneme3");
    user.setPhoneNumber("2323232323");
    userService.addUser(user);
    User result = new User();
    result = userService.findById("2dsadsadasdasdadadaasda");

    Assert.assertEquals(user,result);
}

@Test
public void deleteUser(){

    User user = new User();
    String id = UUID.randomUUID().toString();
    user.setId(id);
    user.setSurname("deneme1");
    user.setName("deneme3");
    user.setPhoneNumber("2323232323");
    userService.addUser(user);
    userService.deleteUser(id);
    User result = userService.findById(id);

    Assert.assertNotEquals(user, result);

    }

/*@Test
public void UpdateUser(){

    IUserService IUserService = new UserServiceImpl();
    User user = new User();
    user.setId("88ce5054-1671-44cb-a4d5-b2461982250b1");
    user.setSurname("mert");
    user.setName("özen");
    user.setPhoneNumber("2323232323");

    IUserService.updateUser(userId, name,surname, phoneNumber);

}*/

}





