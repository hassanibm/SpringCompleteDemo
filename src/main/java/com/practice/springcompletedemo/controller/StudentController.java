package com.practice.springcompletedemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practice.springcompletedemo.model.StudentModel;
import com.practice.springcompletedemo.service.StudentService;

import io.swagger.annotations.Api;

@Api
@RestController("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping("/save")
	public StudentModel saveStudent(@RequestBody StudentModel student) {

		StudentModel savedStudent = studentService.save(student);
		return savedStudent;

		// return studentService.save(student);
	}

	@GetMapping("/get")
	public StudentModel getStudentById(@RequestParam("studentId") int studentId) {

		StudentModel student = studentService.getStudentById(studentId);
		return student;

		// return studentService.save(student);
	}
	
	@GetMapping("/getAllStudents")
	public List<StudentModel> getAllStudents() {

		return studentService.getAllStudents();
	}

	@PutMapping("/update")
	public String updateStudent(@RequestBody StudentModel student) {

		// studentService.update(student);

		boolean isStudentExist = studentService.isStudentExist(student.getRollNo());

		if (isStudentExist) {
			studentService.update(student);
			return "Record Updated successfully.";

		} else {
			return "Student Not Exist in DB.";
		}

	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteStudent(@PathVariable("id") int studentId) {
		studentService.deleteStudent(studentId);
		
	}
}
