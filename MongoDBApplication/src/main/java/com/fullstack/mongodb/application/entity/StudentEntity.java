package com.fullstack.mongodb.application.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
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
	
	
	//Referring to separate collections and not embedded sub-documents
	
	
	/*One-To-One*/
	@DBRef
	private DepartmentEntity department;
	
	/*One-To-Many*/
	@DBRef
	private List<SubjectEntity> subjects;
	
	
	
	//Transient Value
	@Transient
	private double percentage;
	

}
