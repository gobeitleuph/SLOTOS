package com.example.order.component.structure;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="orderpos")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderPositionEntity {
    @Id
    @Column(name = "orderpos_id", nullable = false)
    private Integer orderpos_id;
    private Integer articleId;
    private int articleQuantity;

//    @OneToOne(cascade=CascadeType=ALL, fetch=FetchType.LAZY)
//	public void setArticle(ArticleEntity articleEntity) {
//		this.articleEntity = articleEntity;
//	}

//hallo
}
