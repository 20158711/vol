package com.volunteer.service.impl;

import com.volunteer.pojo.EntryForm;
import com.volunteer.service.EntryFormService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EntryFormServiceImplTest {

    @Autowired
    private EntryFormService entryFormService;

    @Test
    public void save() {
        EntryForm entryForm=new EntryForm();
        entryForm.setUserId(1L);
        entryForm.setArticleId(5L);
        System.out.println(entryFormService.save(entryForm));
    }
}