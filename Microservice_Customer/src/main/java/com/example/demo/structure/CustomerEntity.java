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
public class CustomerEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String address;

	@OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private CartEntity cart;

	public CustomerEntity (String name, String address){
		this.name = name;
		this.address = address;
		this.cart = new CartEntity();
	}




}
