package com.fullstack.mongodb.application.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.fullstack.mongodb.application.entity.StudentEntity;


@Repository
public interface StudentRepository extends MongoRepository<StudentEntity, String> {
	
	
	List<StudentEntity> findByName(String name);
	
	List<StudentEntity> findByNameAndEmail(String name,String email);
	
	List<StudentEntity> findByDepartmentId(String id);
	
	
	//Native Query Example
	
	@Query("{\"name\" : \"?0\"}")
	List<StudentEntity> findStudentByName(String name);
	

}
