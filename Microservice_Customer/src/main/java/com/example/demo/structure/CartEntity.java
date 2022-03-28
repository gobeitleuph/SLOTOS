package com.example.demo.structure;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Table(name="cart")
@Data
public class CartEntity {

	public CartEntity (CustomerEntity customer){
		//this.customer = customer;
		this.items = new HashSet<CartItemEntity>();
	}

	@Id
	@Column(name = "cart_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;

	//@JsonIgnore
//	@OneToOne
//	@MapsId
//	@JoinColumn(name = "customer_id")
//	private CustomerEntity customer;

	@OneToMany
	@JoinColumn(name="cartId")
	@EqualsAndHashCode.Exclude
	private Set<CartItemEntity> items;

	private int numberOfCartItems;

}
