package com.example.order.component.structure;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Table(name="orders")
@Entity
@Data
@AllArgsConstructor
public class Order {

	// intrinsic attributes
	@Id
	@GeneratedValue
	private Integer orderId;
	
	// relational attributes
	private int customerId;
	// relation - aggregation
	private Set<OrderPositionEntity> orderPositions;
	
	public Order() {
		orderPositions = new HashSet<OrderPositionEntity>();
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