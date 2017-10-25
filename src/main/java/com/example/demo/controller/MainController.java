package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    private UserDao userDao;

    @GetMapping("/nologin")
    public ModelAndView getNologinPage(Model model) {
        ModelAndView modelAndView = new ModelAndView("nologin");

        List<User> userList = userDao.findAll();
        model.addAttribute("userList", userList);

        return modelAndView;
    }

    @GetMapping("/hello")
    public ModelAndView hello(Model model){
        ModelAndView modelAndView = new ModelAndView("index");

        String hello = "Hello world";
        model.addAttribute("hello", hello);

        List<User> userList = userDao.findAll();
        model.addAttribute("userList", userList);

        User user = new User();
        user.setId(123);
        user.setUsername("Johnyy");
        user.setPassword("123454132");
        model.addAttribute("user", user);

        return modelAndView;
    }

    @GetMapping("/login")
    public ModelAndView getLoginPage(Model model) {
        ModelAndView modelAndView = new ModelAndView("login");
        User user = new User();
        model.addAttribute("user", user);
        return modelAndView;
    }

}
