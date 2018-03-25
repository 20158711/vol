package com.volunteer.service.impl;

import com.volunteer.pojo.Team;
import com.volunteer.service.TeamService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TeamServiceImplTest {

    @Autowired
    private TeamService teamService;

    @Test
    public void findById() {
        System.out.println(teamService.findById(1L));
    }

    @Test
    public void findTeamByLoginNameAndPassword() {
        System.out.println(teamService.findTeamByLoginNameAndPassword("201504","yb3685110"));
    }

    @Test
    public void save() {
        Team team=new Team();
        team.setTeamName("201503班");
        team.setLoginName("201503");
        team.setPassword("yb3685110");
        team.setIntroduce("他们是3班，这是他们的介绍");
        System.out.println(teamService.save(team));
    }

    @Test
    public void findAll() {
        System.out.println(teamService.findAll());
    }
}