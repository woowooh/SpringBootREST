package com.omg.controller;

import com.omg.dto.Result;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
public class MockController {
    @PostMapping("/mock")
    public Result mockPost(@RequestBody Object o) {

        return new Result(o);
    }

    @GetMapping("/mock")
    public Result mockGet() {
        System.out.println("It's invoke OKKKKKKKKK");
        return new Result("ww");
    }
}
