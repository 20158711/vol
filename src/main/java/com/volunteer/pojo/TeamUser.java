package com.volunteer.pojo;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import javax.persistence.*;

@Entity(name = "team_user")
@DynamicInsert
public class TeamUser {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "team_id")
    private Long teamId;

    @Column(name = "state")
    @ColumnDefault("0")
    private Integer state;

    public TeamUser() {
    }

    public TeamUser(Long userId, Long teamId, Integer state) {
        this.userId = userId;
        this.teamId = teamId;
        this.state = state;
    }

    @Override
    public String toString() {
        return "TeamUser{" +
                "id=" + id +
                ", userId=" + userId +
                ", teamId=" + teamId +
                ", state=" + state +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
