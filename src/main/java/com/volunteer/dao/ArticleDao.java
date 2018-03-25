package com.volunteer.dao;

import com.volunteer.pojo.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleDao extends JpaRepository<Article,Long> {

    List<Article> findByType(Integer type);
    List<Article> findByTeamId(Long id);

}
