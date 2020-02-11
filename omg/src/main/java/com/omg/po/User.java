package com.omg.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import java.sql.Timestamp;


@Data
@TableName("user_t")
@Accessors(chain= true)
@EqualsAndHashCode(callSuper=true)
public class User extends BasePO {
    private String password;
    private String account;
    private Timestamp expireTime;
}
