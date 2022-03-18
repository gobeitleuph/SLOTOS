package com.example.demo;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/article") //gibt den Pfad an, unter dem der Microservice zu erreichen ist
public class MicroserviceArticle_Controller {
	
@Autowired 
MicroserviceArticle_Service service;
	
	@GetMapping("/{article_id}")
	public ResponseEntity<Article> get_Article(@PathVariable("article_id") int article_id){
		
		/*RestTemplate restTemplate = new RestTemplate();
		Article article = restTemplate.getForObject("http://article-service/article/" + article_id, Article.class);
		*/

		return ResponseEntity.ok(service.get_article(article_id));
	}
	
	@Transactional
	@PostMapping("/insert_article")
	public void get_article_name_post(@RequestBody Article article){
		service.save_article(article);
	}
	
	/*@GetMapping("/get_articles")
	public Set<Article> get_all_articles*/
	

}
