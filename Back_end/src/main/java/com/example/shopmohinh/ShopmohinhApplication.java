package com.example.shopmohinh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableElasticsearchRepositories(basePackages = "com.example.shopmohinh.repository.elasticsearch")
@EnableJpaRepositories(basePackages = "com.example.shopmohinh.repository.jpa")
@EnableScheduling
public class ShopmohinhApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopmohinhApplication.class, args);
	}

}
