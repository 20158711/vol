package com.volunteer.service.impl;

import com.volunteer.service.TeamUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TeamUserServiceImplTest {

    @Autowired
    private TeamUserService teamUserService;

    @Test
    public void applyAddToTeam() {
        System.out.println(teamUserService.applyAddToTeam(3L,1L));
    }

    @Test
    public void checkState() {
        System.out.println(teamUserService.checkState(3L, 1L, 1));
    }

    @Test
    public void findByTeamIdAndUserId() {
        System.out.println(teamUserService.findByTeamIdAndUserId(3L, 1L));
    }
}