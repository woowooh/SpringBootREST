package com.omg.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.omg.po.User;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class UserService extends BaseService<User> {
    private static String COLUMN_ACCOUNT = "account";
    private static String IS_DELETE = "is_delete";
    private static Short NOT_DELETE = 0;

    public boolean verifyUser(User u) {
        boolean pass = false;
        User userInfo = findUser(u);
        if (userInfo == null) {
            return pass;
        }
        if (userInfo.getPassword().equals(u.getPassword())) {
            pass = true;
        }
        return pass;
    }

    public boolean regist(User u) {
        boolean pass = false;
        User userInfo = findUser(u);
        if (userInfo != null) {
            return pass;
        }
        int r = save(u);
        if (r < 0) {
            return pass;
        }
        pass = true;
        return pass;
    }

    public User findUser(User u ) {
        QueryWrapper<User> condition = createCondition();
        condition.eq(COLUMN_ACCOUNT, u.getAccount())
                .eq(IS_DELETE, NOT_DELETE);
        User userInfo = selectOne(condition);
        return userInfo;
    }

    public List<User> userList() {
        QueryWrapper<User> condition = createCondition();
        condition.eq(IS_DELETE, NOT_DELETE);
        return listByCondition(condition);
    }

    public int disableUser(User user) {
        User u = findUser(user);
        return updateById(u);
    }
}
