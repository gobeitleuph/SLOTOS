package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class}) // Nur solange keine Datenbankverbindung definiert ist
@SpringBootApplication
@EnableJpaRepositories("com.example.*")
@EntityScan("com.example.*")
public class MicroserviceArticleApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceArticleApplication.class, args);
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
	return new RestTemplate();
}

}
//hitheo