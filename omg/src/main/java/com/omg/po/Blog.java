package com.omg.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("blog_t")
@Accessors(chain= true)
@EqualsAndHashCode(callSuper=true)
public class Blog extends BasePO{
    private String title;
    private String content;
    @TableField(value="content_HTML")
    private String contentHTML;
    private String authorName;
    private Long userId;
    @TableField(exist=false)
    private List<Comment> comments;
}
