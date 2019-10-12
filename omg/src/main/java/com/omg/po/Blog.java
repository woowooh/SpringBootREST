package com.omg.po;

import lombok.Data;

import java.util.List;

@Data
public class Blog {
    private Long id;
    private String title;
    private String content;
    private String contentHTML;
    private String authorName;
    private Long userId;
    private List<Comment> comments;
}
