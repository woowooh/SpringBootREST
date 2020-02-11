package com.omg.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain= true)
@TableName("comment_t")
@EqualsAndHashCode(callSuper=true)
public class Comment extends BasePO {
    private Long id;
    private String words;
    @TableField(value = "words_HTML")
    private String wordsHTML;
    private String authorName;
    private Long userId;
    private Long blogId;
}
