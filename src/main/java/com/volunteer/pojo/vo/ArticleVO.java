package com.volunteer.pojo.vo;

import java.util.Date;

/**
 * @author yelei
 * @date 18-3-24
 */
public class ArticleVO {
    private Long id;//活动id
    private String title;//活动名称
    private String content;//活动内容
    private String teamName;//团队名称
    private Date insertTime;//创建活动时间
    private String isInsert;//是否可加入

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

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    public String getIsInsert() {
        return isInsert;
    }

    public void setIsInsert(String isInsert) {
        this.isInsert = isInsert;
    }
}
