package com.example.demo.component.behaviour;
import com.example.demo.connector.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MicroserviceArticleService {

    @Autowired
    ArticleRepository repository;

    public void save_article (ArticleEntity article) {
        repository.save(article);
    }

    public ArticleEntity get_article (Integer id) {
        return repository.getById(id);
    }


    public List<ArticleEntity> findAll() {
        return repository.findAll();
    }
}
