package com.volunteer.dao;

import com.volunteer.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User,Long> {

    User findByLoginNameAndPassword(String loginName,String password);


}
