package com.volunteer.dao;

import com.volunteer.pojo.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TeamDao extends JpaRepository<Team,Long> {

    Team findByLoginNameAndPassword(String loginName,String password);


}
