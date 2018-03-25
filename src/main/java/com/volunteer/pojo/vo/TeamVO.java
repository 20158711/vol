package com.volunteer.pojo.vo;

import java.awt.*;

/**
 * @author yelei
 * @date 18-3-25
 */
public class TeamVO {
    private Long id;//团队id
    private String teamName;//团队名字
    private String introduce;//团队介绍
    private String username;//队长
    private Integer state;//是否审核

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
