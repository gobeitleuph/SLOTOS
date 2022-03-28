package com.example.demo.structure;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Table(name="customers")
@Entity
@Data						
@NoArgsConstructor
@AllArgsConstructor	
public class CustomerEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String address;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cart_id")
	private CartEntity cart;

	public CustomerEntity (String name, String address){
		this.name = name;
		this.address = address;
		this.cart = new CartEntity();
	}




}
