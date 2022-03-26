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
	private Integer cartItemId;

	@ManyToOne
	@JoinColumn(name = "cart_item_id", insertable = false, updatable = false)
	private CartEntity cart;
	private int articleId;
	private int quantity;

	public CartItemEntity(Integer customerId, CartEntity cart, int articleId){
		this.cartItemId = customerId;
		this.cart = cart;
		this.articleId = articleId;
		this.quantity++;
	}

}
