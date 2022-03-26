package com.example.demo.structure;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Cart {
	
	private Map<Integer, CartItem> cartItems;
	private int numberOfCartItems;	
	private int customerId;	//übergabe von customerID?
	private int itemId; //übergabe von articleID?
	
	
	
	public Cart(int cartId) {
		cartItems = new HashMap<Integer, CartItem>();
		numberOfCartItems = 0;
	}
	
	

	public void createCart(int cartId) {
		new Cart(customerId);
	}
	
	
//	public void addArticleToCart(Integer cartId, Integer itemId) {
//		CartItem foundArticle = getCartItem(itemId);
//
//		Cart cart = customers.get(cartId).getCart();
//
//		cart.addCartItem(foundArticle);
//	}

	



	public void addArticleToCart(CartItem item) {
		//Integer articleId = article.getArticleId();
		CartItem cartItem;
		
		cartItem = new CartItem();
		cartItems.put(itemId, cartItem);
		
		numberOfCartItems++;

	}
	

	public  void removeArticlesFromCart() {
		for (CartItem cartItem : cartItems.values()) {
			if (cartItem.getCartItemId() == (itemId)) {
				cartItems.remove(cartItem.getCartItemId());
				break;
			}
		}

	}

	public void checkout() {
		getNumberOfCartItems();
		getCartItems();
	//	getTotalPrice();

	}
	
	public int getNumberOfCartItems() {
		return numberOfCartItems;
	}
	
	public Collection<CartItem> getCartItems() {
		return cartItems.values();
		
	}
	
//	public double getTotalPrice() {
//		double totalPrice = 0.0;
//		CartItem item;
//		
//		for (CartItem cartItem : getCartItems()) {
//			item = cartItem.getItem();
//		
//		totalPrice += cartItem.getQuantity() * item.getCartItemPrice();
//		}
//		return totalPrice;
//		
//	}
	

	}
