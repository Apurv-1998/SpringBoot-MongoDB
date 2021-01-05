package com.fullstack.mongodb.application.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.fullstack.mongodb.application.entity.StudentEntity;


@Repository
public interface StudentRepository extends MongoRepository<StudentEntity, String> {
	
	List<StudentEntity> findByName(String name);
	
	List<StudentEntity> findByNameAndEmail(String name,String email);
	
	List<StudentEntity> findByDepartmentDepartmentName(String department_name);
	
	List<StudentEntity> findBySubjectsSubjectName(String subject_name);
	

}
