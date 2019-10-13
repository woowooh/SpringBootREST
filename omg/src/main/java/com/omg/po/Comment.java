package com.omg.po;

import lombok.Data;

@Data
public class Comment {
    private Long id;
    private String words;
    private String wordsHTML;
    private String authorName;
    private Long userId;
    private Long blogId;
}
