package com.example.order.component.structure;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Table(name="orders")
@Entity
public class Order {

	// intrinsic attributes
	private Integer orderId;
	
	// relational attributes
//	private int customerId;
	// relation - aggregation
	private Set<OrderPositionEntity> orderPositions;
	
	public Order() {
		orderPositions = new HashSet<OrderPositionEntity>();
	}
	
	@Id
	@GeneratedValue
	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

//	public int getCustomerId() {
//		return customerId;
//	}
//
//	public void setCustomerId(int customerId) {
//		this.customerId = customerId;
//	}

	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name = "fk_orderId", referencedColumnName = "orderId")
	public Set<OrderPositionEntity> getOrderPositions() {
		return orderPositions;
	}

	public void setOrderPositions(Set<OrderPositionEntity> orderPositions) {
		this.orderPositions = orderPositions;
	}

}