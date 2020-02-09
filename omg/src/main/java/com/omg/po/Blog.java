package com.omg.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Timestamp;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("blog_t")
public class Blog {
    private Long id;
    private String title;
    private String content;
    @TableField(value = "content_HTML")
    private String contentHTML;
    private String authorName;
    private Long userId;
    @TableField(exist = false)
    private List<Comment> comments;
    @TableField(value = "is_delete")
    private Short deleted;
    private Timestamp create_time;
    private Timestamp update_time;
}
