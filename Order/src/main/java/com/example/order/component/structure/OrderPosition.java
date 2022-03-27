package com.example.order.component.structure;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.order.component.behaviour.OrderService;

import lombok.Data;

@Table(name="orderpos")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderPosition {

	@Id
	@Column(name = "orderpos_id", nullable = false)
	@ManyToOne
	private Order order;
	private Integer orderposId;
	private Integer articleId;
	private Integer Quantity;


}
