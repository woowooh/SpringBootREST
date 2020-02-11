package com.omg.controller;

import com.omg.dto.Result;
import com.omg.service.UserService;
import com.omg.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/user")
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

    @PostMapping("/disable")
    public Result disable(@RequestBody User user) {
        int code = 0;
        String message = "ok";
        int i = userService.disableUser(user);
        if (i != 1) {
           code = 1;
           message = "Failed operation";
        }
        return new Result(code, message);
    }
}
