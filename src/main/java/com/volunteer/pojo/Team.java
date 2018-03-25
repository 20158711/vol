package com.volunteer.pojo;

import org.hibernate.annotations.DynamicInsert;
import javax.persistence.*;

@DynamicInsert
@Entity(name = "team")
public class Team {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "login_name",nullable = false)
    private String loginName;

    @Column(name = "team_name",nullable = false)
    private String teamName;

    @Column(name = "password",nullable = false)
    private String password;

    @Column(name = "introduce",nullable = false)
    private String introduce;
    @Column(name = "leader",nullable = false)
    private Long leader;

    public Team() {
    }

    public Team(String loginName, String teamName, String password, String introduce, Long leader) {
        this.loginName = loginName;
        this.teamName = teamName;
        this.password = password;
        this.introduce = introduce;
        this.leader = leader;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public Long getLeader() {
        return leader;
    }

    public void setLeader(Long leader) {
        this.leader = leader;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", loginName='" + loginName + '\'' +
                ", teamName='" + teamName + '\'' +
                ", password='" + password + '\'' +
                ", introduce='" + introduce + '\'' +
                ", leader=" + leader +
                '}';
    }
}
