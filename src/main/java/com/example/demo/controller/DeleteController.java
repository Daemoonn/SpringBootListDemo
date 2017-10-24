package com.example.demo.controller;

import com.example.demo.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DeleteController {
    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/hello/{id}", method = RequestMethod.DELETE)
    public Object deleteUser(@PathVariable("id") Integer id) {
        userDao.delete(id);
        System.out.println(id + " was deleted----------------!!!!!!!!!!!!");
        return null;
    }
}
