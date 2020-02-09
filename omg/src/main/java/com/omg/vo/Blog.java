package com.omg.vo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;


@Data
public class Blog {
    private Long blogId;
    private String title;
    private String content;
    private String authorName;
    private Long userId;
}
