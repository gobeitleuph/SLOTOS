package com.example.shop.Shop.component.behaviour;

import com.example.shop.Shop.component.behaviour.structure.Article;
import com.example.shop.Shop.component.behaviour.structure.ShopCatalog;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ShopService {

    private RestTemplate restTemplate;



    public ShopService (){
        this.restTemplate = new RestTemplate();
    }

    public Set<Article> getArticlesForShop (){
        Article[] articleArray =  restTemplate.getForObject("localhost:9191/articles/get_articles", Article[].class);
        Set<Article> articleSet = Arrays.stream(articleArray).collect(Collectors.toSet());
        return articleSet;
    }

    public void InsertArticle(Article article){
        restTemplate.put("localhost:9191/articles/insert_article", article);
    }

    public Article getArticle(Integer articleId){
        Article article = restTemplate.getForObject("localhost:9191/articles/"+articleId, Article.class);
        return article;
    }
}
