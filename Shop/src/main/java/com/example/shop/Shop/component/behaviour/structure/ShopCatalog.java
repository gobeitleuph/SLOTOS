package com.example.shop.Shop.component.behaviour.structure;

import lombok.AllArgsConstructor;

import java.util.Set;

@AllArgsConstructor
public class ShopCatalog {
    private int catalogId;
    private Set<Article> articles;



    public int getCatalogId() {
        return catalogId;
    }

    public Set<Article> getArticles() {
        return articles;
    }

    public void setArticles(Set<Article> articles) {
        this.articles = articles;
    }

    public Article getArticle(int articleId) {
        Article foundArticle = null;

        for (Article article : articles) {
            if (article.getArticleId() == articleId) {
                foundArticle = article;
                break;
            }
        }

        return foundArticle;
    }

}
