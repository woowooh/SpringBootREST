package com.omg.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.sql.Timestamp;


@Data
@TableName("user_t")
public class User {
    private String password;
    private String account;
    @TableField(value = "is_delete")
    private Short deleted;
    private Timestamp create_time;
    private Timestamp update_time;
}
