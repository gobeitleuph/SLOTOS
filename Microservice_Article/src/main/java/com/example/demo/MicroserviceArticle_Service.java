package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MicroserviceArticle_Service {

	@Autowired Article_Repository repository;
	
	public void save_article (Article article) {
		repository.save(article);
	}
	
	public Article get_article (Integer id) {
		return repository.getById(id);
	}

	
}
