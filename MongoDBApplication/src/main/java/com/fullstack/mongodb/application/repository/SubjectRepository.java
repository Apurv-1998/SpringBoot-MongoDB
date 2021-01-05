package com.fullstack.mongodb.application.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.fullstack.mongodb.application.entity.SubjectEntity;


@Repository
public interface SubjectRepository extends MongoRepository<SubjectEntity, String> {
	
	

}
