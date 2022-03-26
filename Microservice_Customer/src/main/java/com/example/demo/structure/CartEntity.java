package com.example.demo.structure;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@Table(name="cart")
public class CartEntity {

	@Id
	@Column(name = "customer_id")
	private Long id;

	@OneToOne
	@MapsId
	@JoinColumn(name = "customer_id")
	private CustomerEntity customer;

	@OneToMany
	@JoinColumn(name="cart_item_id")
	private Set<CartItemEntity> items;

	private int numberOfCartItems;

	}
