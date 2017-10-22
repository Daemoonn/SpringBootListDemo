package com.example.demo;

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

//    @PostMapping("/hello")
//    public String update(@ModelAttribute User user) {
//        return "result";
//    }

//    @DeleteMapping("/hello")
//    public String delete(@RequestParam("id") String id) {
//        System.out.println("Delete Call!!!!");
//        return "index";
//    }

//    @GetMapping("/hello/{id}")
//    public String retweet(@PathVariable long id) {
//        System.out.println("retweet------------!!!");
//        return "/hello";
//    }
}
