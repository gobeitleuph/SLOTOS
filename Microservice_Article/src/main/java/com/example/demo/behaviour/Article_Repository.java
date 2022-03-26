package com.example.demo.behaviour;

import java.util.List;

import com.example.demo.structure.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Article_Repository extends JpaRepository<ArticleEntity, Integer> {
	
}
