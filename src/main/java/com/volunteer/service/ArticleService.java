package com.volunteer.service;

import com.volunteer.pojo.Article;

import java.util.List;

public interface ArticleService {

    Article findById(Long id);
    List<Article> findByType(Integer type);
    Article save(Article article);
    List<Article> findAll();
    List<Article> findByTeamId(Long id);
}
