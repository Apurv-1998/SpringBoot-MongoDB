package com.fullstack.mongodb.application.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.fullstack.mongodb.application.entity.DepartmentEntity;


@Repository
public interface DepartmentRepository extends MongoRepository<DepartmentEntity, String> {
	
	

}
