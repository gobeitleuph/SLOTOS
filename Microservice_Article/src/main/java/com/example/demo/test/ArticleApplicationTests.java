package com.example.demo.test;

import com.example.demo.connector.ArticleController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
@ExtendWith(SpringExtension.class)
@SpringBootTest
//TODO:Tutorial
//https://howtodoinjava.com/spring-boot2/testing/spring-boot-2-junit-5/
public class ArticleApplicationTests {

    @Autowired
    ArticleController ArticleController;
//Testing if Application Loads Correctly
    @Test
    public void contextLoads() {
        Assertions.assertThat(ArticleController).isNotNull();
    }

}
