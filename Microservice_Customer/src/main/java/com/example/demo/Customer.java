package com.example.demo;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data; 
import lombok.NoArgsConstructor;

@Table(name="customers")
@Entity
@Data						
@NoArgsConstructor
@AllArgsConstructor	
public class Customer implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Cart cart;

	//TODO erstmal raus, weil nicht gefordert
//	private String lastName;
// 	private String firstName;


	//private Integer age;
	//private String mailAdress;
	
	
		
	
	

	
}
