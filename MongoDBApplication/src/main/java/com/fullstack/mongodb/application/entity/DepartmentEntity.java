package com.fullstack.mongodb.application.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;




@Document(collection = "department")
@Data
public class DepartmentEntity {
	
	@Id
	private String id;
	
	@Field(name = "department_name")
	private String departmentName;
	
	private String location;

}
