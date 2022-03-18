//package com.example.order.component.structure;
//
//import java.util.HashSet;
//import java.util.Set;
//
//import javax.persistence.*;
//
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Table(name="orders")
//@Entity
//public class Order {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int orderId;
//    private int customerId;
//    // 1:M relation
//    @OneToMany(cascade = CascadeType.REMOVE)
//    //private Set<OrderPositionEntity> orderPositions;
//
//    }
//
//    public void setOrderId(Integer orderId) {
//        this.orderId = orderId;
//    }
//
//    public Integer getOrderId() {
//        return orderId;
//    }
//
//	public int getCustomerId() {
//		return customerId;
//	}
//
//	public void setCustomerId(int customerId) {
//		this.customerId = customerId;
//	}
//
//
//
////    public void setOrderPositions(Set<OrderPositionEntity> orderPositions) {
////        this.orderPositions = orderPositions;
////    }
//
//    public int getNumberOfArticles() {
//        // TODO Auto-generated method stub
//        return 0;
//    }
//
//   /* public double getTotalPrice() {
//        double totalPrice = 0.0;
//
//        Article article;
//        for (OrderPositionEntity orderPosition : orderPositions) {
//            article = orderPosition.getArticle();
//
//            totalPrice += orderPosition.getArticleQuantity() * article.getPrice();
//        }
//
//        return totalPrice;
//    }*/
//
//	public String getArticleId() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//}
