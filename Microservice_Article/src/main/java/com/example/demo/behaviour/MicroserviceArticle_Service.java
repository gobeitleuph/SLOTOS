package com.example.demo.behaviour;

import com.example.demo.structure.ArticleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MicroserviceArticle_Service {

	@Autowired Article_Repository repository;
	
	public void save_article (ArticleEntity article) {
		repository.save(article);
	}
	
	public ArticleEntity get_article (Integer id) {
		return repository.getById(id);
	}

	
}
