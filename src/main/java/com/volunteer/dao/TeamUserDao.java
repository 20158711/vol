package com.volunteer.dao;

import com.volunteer.pojo.TeamUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamUserDao extends JpaRepository<TeamUser,Long>{

    TeamUser findByTeamIdAndUserId(Long teamId,Long userId);
    List<TeamUser> findByUserIdNot(Long userId);
    List<TeamUser> findByUserId(Long userId);
    List<TeamUser> findByTeamId(long teamId);
    List<TeamUser> findByTeamIdAndState(Long teamId,Integer state);

}
