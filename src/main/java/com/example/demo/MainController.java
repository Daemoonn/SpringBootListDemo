package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    private UserDao userDao;

    @RequestMapping("/hello")
    public ModelAndView hello(Model model){
        ModelAndView modelAndView = new ModelAndView("index");

        String hello = "Hello world";
        model.addAttribute("hello", hello);

        List<User> userList = userDao.findAll();
        model.addAttribute("userList", userList);

        return modelAndView;
    }
}
