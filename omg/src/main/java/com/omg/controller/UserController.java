package com.omg.controller;

import com.omg.dto.Result;
import com.omg.service.UserService;
import com.omg.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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

    @GetMapping("/userList")
    public Result userList() {
        List<User> users = userService.userList();
        return new Result(users);
    }
}
