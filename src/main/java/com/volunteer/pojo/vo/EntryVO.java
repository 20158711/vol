package com.volunteer.pojo.vo;

/**
 * @author yelei
 * @date 18-3-25
 */
public class EntryVO {
    private Long id;//活动id
    private String title;//活动名称
    private String content;//活动内容
    private String  username;//申请人
    private Integer age;//申请人年龄

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
