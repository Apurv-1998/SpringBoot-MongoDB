package com.fullstack.mongodb.application.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.fullstack.mongodb.application.entity.StudentEntity;
import com.fullstack.mongodb.application.model.request.CreateStudentDetailsModel;
import com.fullstack.mongodb.application.repository.DepartmentRepository;
import com.fullstack.mongodb.application.repository.StudentRepository;
import com.fullstack.mongodb.application.repository.SubjectRepository;
import com.fullstack.mongodb.application.service.StudentService;


@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	@Autowired
	SubjectRepository subjectRepository;
	
	@Autowired
	ModelMapper mapper;

	@Override
	public StudentEntity createNewStudent(CreateStudentDetailsModel createStudentDetailsModel) {
		// TODO Auto-generated method stub
		
		StudentEntity student = mapper.map(createStudentDetailsModel,StudentEntity.class);
		
		if(student.getDepartment()!=null) {
			departmentRepository.save(student.getDepartment());
		}
		
		if(student.getSubjects()!=null && student.getSubjects().size()>0) {
			subjectRepository.saveAll(student.getSubjects());
		}
		
		return studentRepository.save(student);
		
	}

	@Override
	public StudentEntity getStudentById(String id) {
		
		return studentRepository.findById(id).get();
		
	}

	@Override
	public List<StudentEntity> getAllStudents() {
		
		return studentRepository.findAll();
	}

	@Override
	public StudentEntity updateStudent(String id, CreateStudentDetailsModel createStudentDetailsModel) {
		
		StudentEntity student = studentRepository.findById(id).get();
		
		if(student == null)
			throw new RuntimeException("Student DoesNot Exist");
		
		student = mapper.map(createStudentDetailsModel,StudentEntity.class);
		
		return studentRepository.save(student);
		
		
	}

	@Override
	public String deleteStudent(String id) {
		
		studentRepository.deleteById(id);
		
		return "Student Deleted Successfully";
		
	}

	@Override
	public List<StudentEntity> getStudentByName(String name) {
		
		return studentRepository.findStudentByName(name);
		
	}

	@Override
	public List<StudentEntity> getStudentsByNameAndEmail(String name, String email) {
		
		return studentRepository.findByNameAndEmail(name, email);
		
	}

	@Override
	public List<StudentEntity> getPaginatedStudents(int pageNo, int pageSize) {
		
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		
		return studentRepository.findAll(pageable).getContent();
		
	}

	@Override
	public List<StudentEntity> retuenSortedStudents(String feild) {
		
		Sort sort = Sort.by(Sort.Direction.ASC,feild);
		
		return studentRepository.findAll(sort);
		
	}

	@Override
	public List<StudentEntity> getDepartmentById(String id) {
		
		return studentRepository.findByDepartmentId(id);
		
	}

}
