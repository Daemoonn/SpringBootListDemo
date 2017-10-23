package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UpdateController {
    @Autowired
    private UserDao userDao;

    @RequestMapping("/update/{id}")
    public ModelAndView update(@PathVariable("id") Integer id, Model model) {
        ModelAndView modelAndView = new ModelAndView("edit");
        User user = userDao.findOne(id);
        model.addAttribute("user", user);
        model.addAttribute("rcon", "true");
        return modelAndView;
    }

    @PostMapping(value = "/update")
    public String update(@ModelAttribute User user) {
        userDao.save(user);
        return "redirect:/hello";
    }
}
