package com.example.demo.structure;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CartItemDto {

    private Integer cartItemId;
    private int articleId;
    private int quantity;
}