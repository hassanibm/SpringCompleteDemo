package com.practice.springcompletedemo.service;

import java.util.List;
import java.util.stream.Collectors;

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

	public boolean isStudentExist(int rollNo) {
		StudentEntity studentEntity = studentRepository.findByRollNo(rollNo);
		if (studentEntity != null) {
			return true;
		} else {
			return false;
		}
	}

	public void update(StudentModel student) {
		StudentEntity updateStudentEntity = StudentToStudentEntityConverter.convertModelToEntity(student);
		StudentEntity existingStudentEntity = studentRepository.findByRollNo(student.getRollNo());
		
		updateStudentEntity.setId(existingStudentEntity.getId());
		studentRepository.save(updateStudentEntity);
	}

	public void deleteStudent(int studentId) {
		studentRepository.deleteById(studentId);
	}

	public List<StudentModel> getAllStudents() {
		List<StudentEntity> studentEntities = studentRepository.findAll();
		
		List<StudentModel> students = studentEntities.stream()
				.map(StudentToStudentEntityConverter::convertEntityToModel).collect(Collectors.toList());
		return students;	
	}

}
