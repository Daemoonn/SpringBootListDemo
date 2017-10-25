package com.example.demo.controller;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;

@RestController
public class DeleteController {
    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/hello/{id}", method = RequestMethod.DELETE)
    public Object deleteUser(@PathVariable("id") Integer id) {
        String path = "D:\\NIIThn\\demo\\src\\main\\webapp\\";
        User userInDb = userDao.findOne(id);
        try {
            File DelFile = new File(path + userInDb.getAvataruuid() + ".jpg");
            DelFile.delete();
        } catch (Exception e) {
            System.out.println("fromDeleteController------------------------error!");
            System.out.println(e);
        }
        userDao.delete(id);
        System.out.println(id + " was deleted----------------!!!!!!!!!!!!");
        return null;
    }
}
