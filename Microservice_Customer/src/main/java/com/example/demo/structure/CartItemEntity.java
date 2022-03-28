package com.example.demo.structure;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
@Table(name="cart_items")
public class CartItemEntity {


	@Id
	@Column(name = "cart_item_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer cartItemId;
	private int articleId;
	private int quantity;
	private int cartId;

	public CartItemEntity(Integer cartId, int articleId){
		this.cartId = cartId;

		this.articleId = articleId;
		this.quantity++;
	}

}
