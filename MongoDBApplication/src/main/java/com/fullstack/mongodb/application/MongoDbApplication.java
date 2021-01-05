package com.fullstack.mongodb.application;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("com.fullstack.mongodb.application.repository")
public class MongoDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoDbApplication.class, args);
	}
	
	@Bean
	public ModelMapper modelMapper() {
		
		ModelMapper mapper = new ModelMapper();
		
		
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		return mapper;
		
	}

}
