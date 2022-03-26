package com.example.demo.structure;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@Table(name="cart")
@Data
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
