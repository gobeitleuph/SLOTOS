package com.example.shop.Shop.component.behaviour;

import com.example.shop.Shop.component.behaviour.structure.Article;
import com.example.shop.Shop.component.behaviour.structure.ShopCatalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Set;

@RestController
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    ShopService service;

    @GetMapping("/getCatalog")
    public ShopCatalog getArticles() {
        return new ShopCatalog(1, service.getArticlesForShop());
    }

    @PostMapping("/insertArticle")
    public String insertArticle (@RequestBody Article article){
        service.InsertArticle(article);
        return "article inserted";
    }

    @GetMapping("/getArticle")
    public Article article (@RequestParam("articleId") Integer articleId){
        return service.getArticle(articleId);
    }
}
