package com.volunteer.service;

import com.volunteer.pojo.Notice;

import java.util.List;

/**
 * @author yelei
 * @date 18-3-25
 */
public interface NoticeService {
    List<Notice> findTeamNotice(Long id);
    List<Notice> findAll(Long id);
    Notice addNotice(Notice notice);
    void delSyNotice(Long id);
    void delTeamNotice(Long id);
}
