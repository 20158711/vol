package com.volunteer.dao;

import com.volunteer.pojo.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yelei
 * @date 18-3-25
 */
@Repository
public interface NotinceDao extends JpaRepository<Notice,Long> {
    List<Notice> findByTeamIdAndType(Long id,Integer i);
    void deleteById(Long id);

}
