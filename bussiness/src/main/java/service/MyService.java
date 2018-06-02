package service;

import bean.User;
import mapper.UserMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

/**
 * Created by Wanghairui on 2017/5/22.
 */
@Service
public class MyService {

    @Autowired
    UserMapper mapper;

//    @Autowired
//    TransactionTemplate transactionTemplate;

    private static Logger logger = Logger.getLogger(MyService.class);

    @Transactional
    public List<User> getData(User user) {
        logger.info("---------------------测试------------------------------");
        return mapper.getUserList(user);
    }

    public User getUser(String id){
        User  user= mapper.getUser(id);
        return user;
    }
}
