package com.example.order.component.structure;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


// hier kein POJO wg. RMI (Serializable), da das Serializable invasive ist
// Java Bean
@Entity
//@Table(name="DB_ARTICLE")
public class ArticleEntity implements Serializable {
	
	@Id
	@GeneratedValue
	private Integer articleId;
	private String manufactor;
	private String name;
	private float price;

	public ArticleEntity() {
	}
	
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}

	public int getArticleId() {
		return articleId;
	}

	public String getManufactor() {
		return manufactor;
	}

	public void setManufactor(String manufactor) {
		this.manufactor = manufactor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

}