package com.volunteer.service;

import com.volunteer.pojo.Team;

import java.util.List;

public interface TeamService {

    Team findById(Long id);
    Team findTeamByLoginNameAndPassword(String loginName,String password);
    Team save(Team team);
    List<Team> findAll();

}
