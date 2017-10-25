package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.*;
import java.util.UUID;

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
    public String update(@ModelAttribute User user, @RequestParam(value = "avatarfile")MultipartFile file) {
        Integer id = user.getId();
        String uuid = UUID.randomUUID().toString();

        System.out.println("id in is : -------------" + id);
        System.out.println("avatarfile: ----------: " +  file);
        System.out.println("avataruuid: ----------: " +uuid);

        String path = "D:\\NIIThn\\demo\\src\\main\\webapp\\";
        User userInDb = userDao.findOne(id);
        try {
            File DelFile = new File(path + userInDb.getAvataruuid() + ".jpg");
            DelFile.delete();
        } catch (Exception e) {
            System.out.println("------------------------error!");
            System.out.println(e);
        }
        if (!file.isEmpty()) {
            try {
                BufferedOutputStream out = new BufferedOutputStream(
                        new FileOutputStream(new File(path + uuid +".jpg")));//保存图片到目录下
                out.write(file.getBytes());
                out.flush();
                out.close();
                String filename=path + uuid +".jpg";
                user.setAvatarurl(filename);
                user.setAvataruuid(uuid);
                userDao.save(user);//增加用户
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return "上传失败," + e.getMessage();
            } catch (IOException e) {
                e.printStackTrace();
                return "上传失败," + e.getMessage();
            }
            return "redirect:/hello";
        } else {
            return "上传失败，因为文件是空的.";
        }
    }

    private void saveUser(User user, MultipartFile file) {

    }
}
