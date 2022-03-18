package com.example.demo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	private String lastName;
	private String firstName;
	//private Integer age;
	//private String mailAdress;
	
	
		
	
	

	
}
