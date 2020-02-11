package com.omg.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Timestamp expireTime;
}
