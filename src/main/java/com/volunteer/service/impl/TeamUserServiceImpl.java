package com.volunteer.service.impl;

import com.volunteer.dao.TeamUserDao;
import com.volunteer.pojo.TeamUser;
import com.volunteer.service.TeamUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("teamUserService")
public class TeamUserServiceImpl implements TeamUserService{

    @Autowired
    private TeamUserDao teamUserDao;


    @Override
    public TeamUser applyAddToTeam(Long teamId, Long userId) {
        TeamUser teamUser=teamUserDao.findByTeamIdAndUserId(teamId,userId);
        if (teamUser==null) {
            teamUser = new TeamUser();
            teamUser.setTeamId(teamId);
            teamUser.setUserId(userId);
            return teamUserDao.save(teamUser);
        }else {
            return null;
        }

    }

    @Override
    public TeamUser checkState(Long teamId, Long userId, Integer state) {
        TeamUser teamUser=teamUserDao.findByTeamIdAndUserId(teamId, userId);
        teamUser.setState(state);
        return teamUserDao.save(teamUser);
    }

    @Override
    public TeamUser findByTeamIdAndUserId(Long teamId, Long userId) {
        return teamUserDao.findByTeamIdAndUserId(teamId, userId);
    }

    @Override
    public List<TeamUser> findByUserId(Long userId) {
        return teamUserDao.findByUserId(userId);
    }

    @Override
    public TeamUser addTeamUser(TeamUser teamUser) {
        return teamUserDao.save(teamUser);
    }

    @Override
    public List<TeamUser> findByTeamId(Long id) {

        return teamUserDao.findByTeamIdAndState(id,1);
    }
}
