package com.volunteer.service.impl;

import com.volunteer.dao.EntryFormDao;
import com.volunteer.pojo.EntryForm;
import com.volunteer.service.EntryFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("entryFormService")
public class EntryFormServiceImpl implements EntryFormService {

    @Autowired
    private EntryFormDao entryFormDao;

    @Override
    public EntryForm save(EntryForm entryForm) {
        return entryFormDao.save(entryForm);
    }

    @Override
    public List<EntryForm> findByUserId(Long userId) {
        return entryFormDao.findByUserId(userId);
    }

    @Override
    public EntryForm applyAddToTeam(Long id, Long userId) {
        EntryForm entryForm=entryFormDao.findByArticleIdAndUserId(id,userId);
        if (entryForm==null){
            EntryForm entryForm1=new EntryForm();
            entryForm1.setArticleId(id);
            entryForm1.setUserId(userId);
            return entryFormDao.save(entryForm1);
        }
        return null;
    }

    @Override
    public List<EntryForm> findByAid(Long id) {

        return entryFormDao.findByArticleIdAndState(id,1);
    }
}
