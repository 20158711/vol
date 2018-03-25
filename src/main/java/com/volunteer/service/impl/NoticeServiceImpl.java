package com.volunteer.service.impl;

import com.volunteer.dao.NotinceDao;
import com.volunteer.pojo.Notice;
import com.volunteer.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yelei
 * @date 18-3-25
 */
@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    private NotinceDao notinceDao;

    @Override
    public List<Notice> findTeamNotice(Long id) {
        return notinceDao.findByTeamIdAndType(id,1);
    }

    @Override
    public List<Notice> findAll(Long id) {
        return notinceDao.findByTeamIdAndType(id,0);
    }

    @Override
    public Notice addNotice(Notice notice) {
        return notinceDao.save(notice);
    }

    @Override
    public void delSyNotice(Long id) {
         notinceDao.deleteById(id);
    }

    @Override
    public void delTeamNotice(Long id) {
        notinceDao.deleteById(id);
    }

    @Override
    public List<Notice> getAll() {
        return notinceDao.findByType(0);
    }

    @Override
    public List<Notice> getT() {
        return notinceDao.findByType(1);
    }
}
