package com.example.demo.test;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import com.example.demo.component.behaviour.MicroserviceArticleService;
import com.example.demo.component.structure.ArticleEntity;
import com.example.demo.connector.ArticleController;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ArticleController.class)
public class ArticleControllerTests {

    @MockBean
    MicroserviceArticleService articleService;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void findAll() throws Exception {
        ArticleEntity article = new ArticleEntity(3, "jumbo",  "lego", 12);
        List<ArticleEntity> articles = Arrays.asList(article);

        Mockito.when(articleService.findAll()).thenReturn(articles);

        mockMvc.perform(MockMvcRequestBuilders.get("/get_articles"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[3].name", Matchers.is("jumbo")));

    }

}
