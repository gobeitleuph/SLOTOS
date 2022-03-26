package com.example.demo.test;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import com.example.demo.connector.ArticleController;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.component.structure.ArticleEntity;
import com.example.demo.component.behaviour.MicroserviceArticleService;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@WebMvcTest(ArticleController.class)
public class ArticleControllerTests {

    @MockBean
    MicroserviceArticleService articleService;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void get_Article() throws Exception {
        ArticleEntity article = new ArticleEntity(1, "jumbo",  "lego", 12);

        //given(ArticleController.get_Article(article.getId())).willReturn(article);

        Mockito.when(articleService.get_article(1)).thenReturn(article);

        mockMvc.perform(MockMvcRequestBuilders.get("/article/"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("id[1].name", Matchers.is("jumbo")));

    }

}
