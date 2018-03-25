package com.volunteer.service.impl;

import com.volunteer.dao.UserDao;
import com.volunteer.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author yelei
 * @date 18-3-24
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceImplTest {
    @Autowired
    private UserDao userDao;
    @Test
    public void save() throws Exception {
        User user=new User();
        user.setAge(21);
        user.setLoginName("ye");
        user.setPassword("ye");
        user.setUsername("ye");
        user.setPersonalizedSignature("lalala");
        userDao.save(user);
    }

}