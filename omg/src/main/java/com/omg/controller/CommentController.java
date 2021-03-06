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
        CommentService.save(comment);
        System.out.println(comment);
        return Result.successResult();
    }

//    @PostMapping("/updateComment")
//    public Result updateComment(@RequestBody Comment Comment) {
//        CommentService.updateComment(Comment);
//        return Result.successResult();
//    }

    @GetMapping("/Comment/{CommentId}")
    public Result getComment(@PathVariable("CommentId")Long CommentId) {
        Comment b = CommentService.findById(CommentId);
        return Result.successResult(b);
    }

    @GetMapping("/Comments/{BlogId}")
    public Result getComments(@PathVariable("BlogId")Long BlogId) {
        List<Comment> comments = CommentService.listByBlogId(BlogId);
        return Result.successResult(comments);
    }

    @GetMapping("/deleteComment/{commentId}")
    public Result deleteComment(@PathVariable("commentId")Long commentId) {
        System.out.println("wwwwwwwww");
        System.out.println(CommentService.deleteById(commentId));

        return Result.successResult();
    }

//    @GetMapping("/deleteComment/{CommentId}")
//    public Result deleteComment(@PathVariable("CommentId")long CommentId) {
//        CommentService.deleteComment(CommentId);
//        return Result.successResult();
//    }
}
