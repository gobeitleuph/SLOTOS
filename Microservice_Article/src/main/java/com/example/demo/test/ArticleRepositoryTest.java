package com.example.demo.test;
import com.example.demo.connector.ArticleRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.demo.component.structure.ArticleEntity;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ArticleRepositoryTest {

    @Autowired
    ArticleRepository articleRepository;

    @Test
    public void testCreateReadDelete() {
        ArticleEntity article = new ArticleEntity(1, "jumbo",  "lego", 12);
        articleRepository.save(article);

        ArticleEntity found = articleRepository.getById(1);
        Assertions.assertThat(article.getName()).isEqualTo(found.getName());

       // articleRepository.deleteAll();

    }


}
