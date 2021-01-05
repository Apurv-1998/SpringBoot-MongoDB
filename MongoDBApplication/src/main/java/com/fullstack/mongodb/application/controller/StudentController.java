package com.fullstack.mongodb.application.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fullstack.mongodb.application.entity.StudentEntity;
import com.fullstack.mongodb.application.model.request.CreateStudentDetailsModel;
import com.fullstack.mongodb.application.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	ModelMapper mapper;
	
	@PostMapping(path = "/signup")
	public StudentEntity  createStudent(@RequestBody CreateStudentDetailsModel createStudentDetailsModel) {
		
		return studentService.createNewStudent(createStudentDetailsModel);
		
	}
	
	
	@GetMapping(path = "/{id}/getStudent")
	public StudentEntity getStudent(@PathVariable String id) {
		
		return studentService.getStudentById(id);
		
	}
	
	
	@GetMapping(path = "/allStudents")
	public List<StudentEntity> getAllStudents(){
		
		return studentService.getAllStudents();
		
	}
	
	@PutMapping(path = "/{id}/updateStudent")
	public StudentEntity updateStudent(@PathVariable String id, @RequestBody CreateStudentDetailsModel createStudentDetailsModel) {
		
		return studentService.updateStudent(id,createStudentDetailsModel);
		
	}
	
	@DeleteMapping(path = "/{id}/deleteStudent")
	public String deleteStudent(@PathVariable String id) {
		
		return studentService.deleteStudent(id);
		
	}
	
	
	@GetMapping(path = "/{name}/getStudentsByName")
	public List<StudentEntity> getStudentsByName(@PathVariable String name){
		
		return studentService.getStudentByName(name);
		
	}
	
	
	@GetMapping(path = "/getStudentsByNameAndEmail")
	public List<StudentEntity> getStudenstByNameAndEmail(@RequestParam String name, @RequestParam String email){
		
		return studentService.getStudentsByNameAndEmail(name,email);
	}
	
	
	@GetMapping(path = "/getPaginatedStudents")
	public List<StudentEntity> getAllPaginatedStudents(@RequestParam(name = "page") int pageNo, @RequestParam(name = "limit") int pageSize){
		
	return studentService.getPaginatedStudents(pageNo,pageSize);
		
	}
	
	
	@GetMapping(path = "/getSortedStudents")
	public List<StudentEntity> getAllStudentsInSortedOrder(@RequestParam(name = "sortBy") String feild){
		
		return studentService.retuenSortedStudents(feild);
		
	}
	
	
	@GetMapping(path = "/{id}/getDepartment")
	public List<StudentEntity> getDepartmentByDepartmentId(@PathVariable String id){
		
		return studentService.getDepartmentById(id);
		
	}
}
