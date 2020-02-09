package com.omg.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Timestamp;


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
    @TableField(value = "is_delete")
    private Short deleted;
    private Timestamp create_time;
    private Timestamp update_time;
}
