package com.volunteer.pojo;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import javax.persistence.*;

@Entity(name = "user")
@DynamicInsert
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "login_name", nullable = false)
    private String loginName;

    @Column(name = "user_name", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "personalized_signature", nullable = false)
    @ColumnDefault("\'这个人很懒什么也没有留下\'")
    private String personalizedSignature;

    @Column(name = "age", nullable = false)
    private Integer age;


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", loginName='" + loginName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", personalizedSignature='" + personalizedSignature + '\'' +
                ", age=" + age +
                '}';
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPersonalizedSignature() {
        return personalizedSignature;
    }

    public void setPersonalizedSignature(String personalizedSignature) {
        this.personalizedSignature = personalizedSignature;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public User() {
    }

    public User(String loginName, String username, String password, String personalizedSignature, Integer age) {
        this.loginName = loginName;
        this.username = username;
        this.password = password;
        this.personalizedSignature = personalizedSignature;
        this.age = age;
    }
}
