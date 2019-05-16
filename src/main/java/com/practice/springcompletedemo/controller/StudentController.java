package com.practice.springcompletedemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practice.springcompletedemo.model.StudentModel;
import com.practice.springcompletedemo.service.StudentService;

import io.swagger.annotations.Api;

@Api
@RestController
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
}
