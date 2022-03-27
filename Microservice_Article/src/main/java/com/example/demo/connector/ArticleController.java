package com.example.demo.connector;

import com.example.demo.component.behaviour.MicroserviceArticleService;
import com.example.demo.component.structure.ArticleEntity;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/articles") //gibt den Pfad an, unter dem der Microservice zu erreichen ist
public class ArticleController {
	
@Autowired
private MicroserviceArticleService service;
	@GetMapping("/{article_id}")
	public ResponseEntity<ArticleEntity> get_Article(@PathVariable("article_id") int article_id){
		
		/*RestTemplate restTemplate = new RestTemplate();
		Article article = restTemplate.getForObject("http://article-service/article/" + article_id, Article.class);
		*/

		return ResponseEntity.ok(service.get_article(article_id));
	}
	
	@Transactional
	@PostMapping("/insert_article")
	public void get_article_name_post(@RequestBody ArticleEntity article){
		service.save_article(article);
	}

	//@GetMapping("/getCatalog")

	@GetMapping("/get_articles")
	public List<ArticleEntity> get_all_articles(){
		return service.get_all_articles();
	}

}
