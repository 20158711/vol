package com.volunteer.pojo;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import javax.persistence.*;
import java.util.Date;

@Entity(name = "article")
@DynamicInsert
public class Article {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "title",nullable = false)
    private String title;

    @Column(name = "content",nullable = false)
    private String content;

    @Column(name = "is_allow_entry",nullable = false)
    private Boolean isAllowEntry;

    @Column(name = "team_id")
    private Long teamId;


    @Column(name = "type")
    @ColumnDefault("0")
    private Integer type;

    @Column(name = "insert_time")
    @ColumnDefault("current_timestamp")
    private Date insertTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getAllowEntry() {
        return isAllowEntry;
    }

    public void setAllowEntry(Boolean allowEntry) {
        isAllowEntry = allowEntry;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    public Article() {
    }

    public Article(String title, String content, Boolean isAllowEntry, Long teamId, Integer type, Date insertTime) {
        this.title = title;
        this.content = content;
        this.isAllowEntry = isAllowEntry;
        this.teamId = teamId;
        this.type = type;
        this.insertTime = insertTime;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", isAllowEntry=" + isAllowEntry +
                ", teamId=" + teamId +
                ", type=" + type +
                ", insertTime=" + insertTime +
                '}';
    }
}
