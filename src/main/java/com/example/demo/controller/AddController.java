package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.*;

@Controller
public class AddController {
    @Autowired
    private UserDao userDao;

    @GetMapping(value = "/add")
    public ModelAndView add(Model model) {
        ModelAndView modelAndView = new ModelAndView("edit");
        User user = new User();
        model.addAttribute("user", user);
        model.addAttribute("rcon", "false");
        return modelAndView;
    }
}
