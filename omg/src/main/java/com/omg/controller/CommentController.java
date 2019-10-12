package com.omg.controller;

import com.omg.dto.Result;
import com.omg.po.Comment;
import com.omg.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class CommentController {
    @Autowired
    private CommentService CommentService;

    @PostMapping("/addComment")
    public Result addComment(@RequestBody Comment comment) {
        CommentService.addComment(comment);
        return Result.successResult();
    }

//    @PostMapping("/updateComment")
//    public Result updateComment(@RequestBody Comment Comment) {
//        CommentService.updateComment(Comment);
//        return Result.successResult();
//    }

//    @GetMapping("/Comment/{CommentId}")
//    public Result getComment(@PathVariable("CommentId")long CommentId) {
//        Comment b = CommentService.findComment(CommentId);
//        return Result.successResult(b);
//    }
//
//    @GetMapping("/deleteComment/{CommentId}")
//    public Result deleteComment(@PathVariable("CommentId")long CommentId) {
//        CommentService.deleteComment(CommentId);
//        return Result.successResult();
//    }
}
