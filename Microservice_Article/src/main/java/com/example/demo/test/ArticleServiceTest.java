package com.example.demo.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.component.behaviour.MicroserviceArticleService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.connector.ArticleRepository;
import com.example.demo.component.structure.ArticleEntity;

@ExtendWith(MockitoExtension.class)
public class ArticleServiceTest {

    @InjectMocks
    MicroserviceArticleService service;

    @Mock
    ArticleRepository dao;

    @Test
    public void testFindAllArticles()
    {
        List<ArticleEntity> list = new ArrayList<ArticleEntity>();
        ArticleEntity empOne = new ArticleEntity(15, "ball", "mercedes", 3);
        ArticleEntity empTwo = new ArticleEntity(9, "disk", "holz", 8);
        ArticleEntity empThree = new ArticleEntity(16, "baseball", "leder", 4);

        list.add(empOne);
        list.add(empTwo);
        list.add(empThree);

        when(dao.findAll()).thenReturn(list);

        //test
        List<ArticleEntity> empList = service.findAll();

        assertEquals(3, empList.size());
        verify(dao, times(1)).findAll();
    }

}
