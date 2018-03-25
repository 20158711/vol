package com.volunteer.service;

import com.volunteer.pojo.EntryForm;

import java.util.List;

public interface EntryFormService {

    EntryForm save(EntryForm entryForm);
    List<EntryForm> findByUserId(Long userId);
    EntryForm findByArticleIdAndUserId(Long articleId,Long userId);
    EntryForm applyAddToTeam(Long id,Long userId);
    List<EntryForm> findByAid(Long id);
    EntryForm findById(Long id);
}
