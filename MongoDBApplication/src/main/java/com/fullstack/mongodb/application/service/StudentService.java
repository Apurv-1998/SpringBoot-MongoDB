package com.fullstack.mongodb.application.service;

import java.util.List;

import com.fullstack.mongodb.application.entity.StudentEntity;
import com.fullstack.mongodb.application.model.request.CreateStudentDetailsModel;

public interface StudentService {

	StudentEntity createNewStudent(CreateStudentDetailsModel createStudentDetailsModel);

	StudentEntity getStudentById(String id);

	List<StudentEntity> getAllStudents();

	StudentEntity updateStudent(String id, CreateStudentDetailsModel createStudentDetailsModel);

	String deleteStudent(String id);

	List<StudentEntity> getStudentByName(String name);

	List<StudentEntity> getStudentsByNameAndEmail(String name, String email);

	List<StudentEntity> getPaginatedStudents(int pageNo, int pageSize);

	List<StudentEntity> retuenSortedStudents(String feild);

	List<StudentEntity> getStudentsByDepartmentName(String department_name);

	List<StudentEntity> getStudentsBySubjectName(String subject_name);

}
