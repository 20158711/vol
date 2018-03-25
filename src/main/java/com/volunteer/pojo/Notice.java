package com.volunteer.pojo;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author yelei
 * @date 18-3-25
 */
@Entity(name = "notice")
@DynamicInsert
public class Notice {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name="teamId")
    private Long teamId;
    @Column(name = "content")
    private String content;
    @Column(name = "insert_time")
    @ColumnDefault("current_timestamp")
    private Date insertTime;
    @Column(name = "type")
    @ColumnDefault("0")

    private Integer type;

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
