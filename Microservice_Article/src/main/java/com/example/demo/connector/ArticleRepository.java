package com.example.demo.connector;

import com.example.demo.component.structure.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<ArticleEntity, Integer> {
	
}
