package com.volunteer.service.impl;

import com.volunteer.pojo.Article;
import com.volunteer.service.ArticleService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ArticleServiceImplTest {

    @Autowired
    private ArticleService articleService;

    private Article article;

    @Before
    public void init(){
        article=new Article();
        article.setTitle("这是第一个测试内容");
        article.setContent("私搭乱建；进城墙 阿斯蒂芬  阿斯蒂芬 茜埒 肝有持阿尔金花托");
        article.setAllowEntry(true);
        article.setTeamId(3L);
    }

    @Test
    public void findById() {
        System.out.println(articleService.findById(1L));
    }

    @Test
    public void findByType() {
        System.out.println(articleService.findByType(0));
    }

    @Test
    public void save() {
        System.out.println(articleService.save(article));
    }
}