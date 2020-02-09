package com.omg.controller;

import com.omg.dto.Result;
import com.omg.service.UserService;
import com.omg.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin
@RestController
public class LoginController {
    @Autowired
    UserService userService;

    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        boolean verifyPass = userService.verifyUser(user);
        return new Result(verifyPass);
    }
}
