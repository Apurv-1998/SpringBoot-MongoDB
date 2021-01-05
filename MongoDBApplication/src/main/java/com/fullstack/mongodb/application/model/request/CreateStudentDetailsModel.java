package com.fullstack.mongodb.application.model.request;

import java.util.List;

import com.fullstack.mongodb.application.entity.DepartmentEntity;
import com.fullstack.mongodb.application.entity.SubjectEntity;

import lombok.Data;

@Data
public class CreateStudentDetailsModel {
	
	private String name;
	private String email;
	private DepartmentEntity department;
	private List<SubjectEntity> subjects;
}
