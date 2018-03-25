package com.volunteer.service.impl;

import com.volunteer.dao.TeamDao;
import com.volunteer.dao.TeamUserDao;
import com.volunteer.dao.UserDao;
import com.volunteer.pojo.Team;
import com.volunteer.pojo.TeamUser;
import com.volunteer.pojo.User;
import com.volunteer.pojo.vo.TeamVO;
import com.volunteer.service.TeamUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("teamUserService")
public class TeamUserServiceImpl implements TeamUserService{

    @Autowired
    private TeamUserDao teamUserDao;

    @Autowired
    private TeamDao teamDao;

    @Autowired
    private UserDao userDao;

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

    @Override
    public List<TeamVO> findTeamVoByTeamIdAndUserIdJoinEd(Long userId) {
        List<TeamUser> teamUserList=teamUserDao.findByUserIdNot(userId);
        return getTeamVo(teamUserList);
    }

    @Override
    public List<TeamVO> findTeamVoByTeamIdAndUserIdNotJoin( Long userId) {
        List<TeamUser> teamUserList = teamUserDao.findByUserId(userId);
        return getTeamVo(teamUserList);
    }

    private List<TeamVO> getTeamVo(List<TeamUser> teamUserList){
        List<TeamVO> teamVOList=new ArrayList<>();
        for (int i = 0; i < teamUserList.size(); i++) {
            Team team=teamDao.findById(teamUserList.get(i).getTeamId()).get();
            User leader=userDao.findById(team.getLeader()).get();
            TeamVO teamVO=new TeamVO();
            teamVO.setUsername(leader.getUsername());
            teamVO.setTeamName(team.getTeamName());
            teamVO.setIntroduce(team.getIntroduce());
            teamVO.setState(teamUserList.get(i).getState());
            teamVOList.add(teamVO);
        }
        return teamVOList;
    }
}
