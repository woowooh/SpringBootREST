package com.omg.controller;

import com.omg.dto.Result;
import com.omg.service.UserService;
import com.omg.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/regist")
    public Result register(@RequestBody User user) {
        boolean verifyPass = userService.regist(user);
        return new Result(verifyPass);
    }

    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        boolean verifyPass = userService.verifyUser(user);
        return new Result(verifyPass);
    }
}
