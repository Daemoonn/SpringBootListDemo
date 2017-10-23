package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

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
