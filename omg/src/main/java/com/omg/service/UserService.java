package com.omg.service;

import com.omg.vo.User;
import org.springframework.stereotype.Service;


@Service
public class UserService extends BaseService<User> {
    public boolean verifyUser(User u) {
        boolean pass = false;
        if (u.getAccount().equals("admin")) {
            if (u.getPassword().equals("admin")) {
                pass = true;
            }
        }
        return pass;
    }
}
