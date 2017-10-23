package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AjaxController {
    @Autowired
    UserDao userDao;

    @RequestMapping(value = "add/ajaxtest", method = RequestMethod.POST)
    public Response postId(@RequestBody Tran tran) {
        String status = "Done";
        Integer id = Integer.parseInt(tran.getId());
        if(userDao.exists(id)) {
            status = "No";
        }
        Response response = new Response(status, tran);
        return response;
    }
}
