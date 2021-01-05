package com.fullstack.mongodb.application.entity;

import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

//Since it is not a separate collection we do not need to mark it with @Document


@Data
public class SubjectEntity {
	
	@Field(name = "subject_name")
	private String subjectName;
	
	@Field(name = "marks_obtained")
	private int marksObtained;

}
