package com.example.demo.controller;

import com.example.demo.*;
import com.example.demo.dao.UserDao;
import com.example.demo.entity.Response;
import com.example.demo.entity.Tran;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    UserDao userDao;

    @PostMapping("login/loginPost")
    public String loginPost(@ModelAttribute User user, HttpSession session) {
        Integer id = user.getId();
        String password = user.getPassword();
        if (!password.equals(userDao.findOne(id).getPassword())) {
            return "redirect:/login";
        }

        // 设置session
        session.setAttribute(WebSecurityConfig.SESSION_KEY, id);

        return "redirect:/hello";
    }

    @RequestMapping(value = "login/logingCheck", method = RequestMethod.POST)
    @ResponseBody
    public Response checkId(@RequestBody Tran tran) {
        String status = "Done";
        Integer id = Integer.parseInt(tran.getId());
        if(!userDao.exists(id)) {
            status = "No";
        }
        Response response = new Response(status, tran);
        return response;
    }
}
