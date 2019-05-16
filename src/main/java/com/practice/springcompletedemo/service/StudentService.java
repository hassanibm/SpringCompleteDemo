package com.practice.springcompletedemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.springcompletedemo.converter.StudentToStudentEntityConverter;
import com.practice.springcompletedemo.entity.StudentEntity;
import com.practice.springcompletedemo.model.StudentModel;
import com.practice.springcompletedemo.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public StudentModel save(StudentModel studentModel) {

		/**
		 * Convert Model To Entity.
		 */
		StudentEntity studentEntity = StudentToStudentEntityConverter.convertModelToEntity(studentModel);
		
		/**
		 * Saved to the database and get the saved object.
		 */
		StudentEntity savedEntity = studentRepository.save(studentEntity);

		/**
		 * Convert Entity To Model and send response back to the controller.
		 */
		return StudentToStudentEntityConverter.convertEntityToModel(savedEntity);
	}

	public StudentModel getStudentById(int studentId) {
		
		StudentEntity studentEntity = studentRepository.findById(studentId).get();

		/**
		 * Convert Entity To Model and send response back to the controller.
		 */
		return StudentToStudentEntityConverter.convertEntityToModel(studentEntity);
	}

}
