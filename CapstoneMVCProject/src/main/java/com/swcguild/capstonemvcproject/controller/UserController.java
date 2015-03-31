package com.swcguild.capstonemvcproject.controller;

import com.swcguild.capstonemvcproject.dao.UserDao;
import com.swcguild.capstonemvcproject.dto.User;
import java.util.List;
import javax.inject.Inject;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class UserController {

    private UserDao userDao;

    @Inject
    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @RequestMapping(value = "/loginpage", method = RequestMethod.GET)
    public String displayloginpage() {
        return "loginpage";
    }
    
    @RequestMapping(value = "/userControl", method = RequestMethod.GET)
    public String displayUserControl() {
        return "userControl";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public User createUser(@RequestBody User user) {
        userDao.addUser(user);
        return user;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    @ResponseBody
    public User getUser(@PathVariable("id") int userId) {
        return userDao.getUserById(userId);
    }

//    @RequestMapping(value = "userControl/user/{id}", method = RequestMethod.PUT)
    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void editUser(@PathVariable("id") int userId, @RequestBody User user) {
        user.setUserId(userId);
//        user.setPassword(userDao.getUserById(userId).getPassword());
        userDao.editUser(user);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable("id") int userId) {
        userDao.deleteUser(userId);
    }
}
