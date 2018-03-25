package com.volunteer.service.impl;

import com.volunteer.dao.UserDao;
import com.volunteer.pojo.User;
import com.volunteer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User findUserByLoginNameAndPassword(String loginName, String password) {
        return userDao.findByLoginNameAndPassword(loginName, password);
    }

    @Override
    public User save(User user) {
        return userDao.save(user);
    }

    @Override
    public User findById(Long id) {
        try {
            return userDao.findById(id).get();
        }catch (NoSuchElementException e){
            System.out.println("id: "+id+" 没有数据");
            return null;
        }
    }

    @Override
    public void updateById(User user) {
        User user1=userDao.findById(user.getId()).get();
        user1.setUsername(user.getUsername());
        user1.setAge(user.getAge());
        user1.setPersonalizedSignature(user.getPersonalizedSignature());
        userDao.save(user1);
    }
}
