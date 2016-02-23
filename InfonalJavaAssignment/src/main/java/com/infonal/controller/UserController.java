package com.infonal.controller;

import com.infonal.model.User;
import com.infonal.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;


/**
 * Created by mert on 2/21/16.
 */


@Controller
public class UserController {

    @Autowired
    private IUserService IUserServiceImp;


    // Controller for getting list of user and show in index page
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getUserList(ModelMap model) {
        // DOMConfigurator.configure("resources/log4j.xml");
        model.addAttribute("userList", IUserServiceImp.listUser());
        //logger.info("personList returned");
        return "index";
    }

    // Controller for saving user
    @RequestMapping(value = "/user/save", method = RequestMethod.POST)
    @ResponseBody
    public User createUser(HttpServletRequest request) {

        System.out.println("id : "+request.getParameter("id") + "name :"+ request.getParameter("name") +
                "surname :" + request.getParameter("surname")+"telno :"+ request.getParameter("phoneNumber"));
        User user = new User();
        // generating random user id
        user.setId(UUID.randomUUID().toString());
        user.setName(request.getParameter("name"));
        user.setSurname(request.getParameter("surname"));
        user.setPhoneNumber(request.getParameter("phoneNumber"));
        IUserServiceImp.addUser(user);
        //logger.info("user saved");
        return user;
    }

  // Controller for delete user
    @RequestMapping(value = "/user/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteUser(@PathVariable String id) {
        IUserServiceImp.deleteUser(id);
        //logger.info("person deleted");
    }

    //Controller for update user
    @RequestMapping(value = "/user/update", method = RequestMethod.POST)
    @ResponseBody
    public User updateUser(HttpServletRequest request) {
        System.out.println("id : "+request.getParameter("id") + "name :"+ request.getParameter("name") +
               "surname :" + request.getParameter("surname")+"telno :"+ request.getParameter("phoneNumber"));

        User user = IUserServiceImp.updateUser(request.getParameter("id"), request.getParameter("name"),
                request.getParameter("surname"), request.getParameter("phoneNumber"));
        //logger.info("person updated");
        return user;
    }



}

