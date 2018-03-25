package com.volunteer.dao;

import com.volunteer.pojo.EntryForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntryFormDao extends JpaRepository<EntryForm,Long> {
    List<EntryForm> findByUserId(Long userId);
    EntryForm findByArticleIdAndUserId(Long id,Long userId);
    List<EntryForm> findByArticleIdAndState(Long id,Integer state);
}
