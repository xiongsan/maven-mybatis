package service;

import bean.User;
import mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Wanghairui on 2017/5/22.
 */
@Service
public class MyService {
    @Autowired
    UserMapper mapper;

    public List<User> getData(User user) {
        return mapper.getUserList(user);
    }
}
