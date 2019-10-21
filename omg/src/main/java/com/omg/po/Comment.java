package com.omg.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("comment_t")
public class Comment {
    private Long id;
    private String words;
    @TableField(value = "words_HTML")
    private String wordsHTML;
    private String authorName;
    private Long userId;
    private Long blogId;
}
