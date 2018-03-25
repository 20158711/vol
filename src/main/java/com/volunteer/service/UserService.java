package com.volunteer.service;

import com.volunteer.pojo.User;

public interface UserService {

    User findUserByLoginNameAndPassword(String loginName,String password);
    User save(User user);
    User findById(Long id);
    void updateById(User user);

}
