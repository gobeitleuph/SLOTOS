package com.example.shop.Shop.component.behaviour.structure;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Article {
    private Integer articleId;
    private String manufactor;
    private String name;
    private float price;


}
