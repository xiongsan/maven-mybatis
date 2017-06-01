package service;

import bean.User;
import mapper.TransactionTestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.Tool;

/**
 * Created by Wanghairui on 2017/5/24.
 */
@Service
public class UserService {

    @Autowired
    TransactionTestMapper transactionTestMapper;

    @Transactional
    public void newUser(){
        User user = new User();
        user.setId(Tool.newGuid().toString());
        user.setAccount("wanghr");
        user.setName("wanghr");
        user.setPassword("123456");
        transactionTestMapper.addUser(user);
        User incorrectUser=new User();
        //uuid36个字符，数据库id字段 数据类型设置为varchar（36）加个w就会溢出，
        // 制造错误的需求是回滚
        incorrectUser.setId(Tool.newGuid().toString()+"w");
        incorrectUser.setAccount("wanghr");
        incorrectUser.setName("1");
        incorrectUser.setPassword("123456");
        transactionTestMapper.addIncorrectUser(incorrectUser);
    }
}
