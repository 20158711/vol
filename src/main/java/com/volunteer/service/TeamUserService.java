package com.volunteer.service;

import com.volunteer.pojo.TeamUser;

import java.util.List;

public interface TeamUserService {

    TeamUser applyAddToTeam(Long teamId, Long userId);
    TeamUser checkState(Long teamId,Long userId,Integer state);
    TeamUser findByTeamIdAndUserId(Long teamId,Long userId);
    List<TeamUser> findByUserId(Long userId);
    TeamUser addTeamUser(TeamUser teamUser);
    List<TeamUser> findByTeamId(Long id);

}
