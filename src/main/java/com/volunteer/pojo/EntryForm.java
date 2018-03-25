package com.volunteer.pojo;


import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@Entity(name = "entry_form")
@DynamicInsert
public class EntryForm {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "article_id")
    private Long articleId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "state")
    @ColumnDefault("0")
    private Integer state;

    public EntryForm() {
    }

    public EntryForm(Long articleId, Long userId, Integer state) {
        this.articleId = articleId;
        this.userId = userId;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "EntryForm{" +
                "id=" + id +
                ", articleId=" + articleId +
                ", userId=" + userId +
                ", state=" + state +
                '}';
    }
}
