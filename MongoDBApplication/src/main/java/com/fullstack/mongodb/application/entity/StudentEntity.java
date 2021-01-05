package com.fullstack.mongodb.application.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "student") //similar to @Table annotation in Spring Data JPA
@Data
@NoArgsConstructor
public class StudentEntity {
	
	@Id
	private String id; //In mongodb it is _id but we dont need to worry with @Feild annotation
	
	private String name;
	
	@Field(name = "mail") //similar to @Column annotation of Spring Data JPA
	private String email;
	
	//Many-to-one with Department
	private DepartmentEntity department; //similar to mongoDB so no need of @Feild
	
	
	//One-to-many with Subjects 
	private List<SubjectEntity> subjects;
	
	
	
/*
 * Since more than one constructor in collection class therefore any one constructor has to be @PersistenceConstructor
 * 
 * */	
	
	@PersistenceConstructor
	public StudentEntity(String id, String name, String email, DepartmentEntity department,List<SubjectEntity> subjects) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.department = department;
		this.subjects = subjects;
	}


	public StudentEntity(DepartmentEntity department, List<SubjectEntity> subjects) {
		super();
		this.department = department;
		this.subjects = subjects;
	}
}
