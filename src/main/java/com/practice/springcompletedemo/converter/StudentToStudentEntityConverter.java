package com.practice.springcompletedemo.converter;

import com.practice.springcompletedemo.entity.StudentEntity;
import com.practice.springcompletedemo.model.StudentModel;

public class StudentToStudentEntityConverter {

	public static StudentEntity convertModelToEntity(StudentModel studentModel) {
		/**
		 * Case 1: using create object using all parameterized constructor.
		 */
//		StudentEntity studentEntity = new StudentEntity(studentModel.getRollNo(), studentModel.getName(),
//				studentModel.getSchoolName(), studentModel.getFavoriteSubject());

		/**
		 * Case 2: using create new blank object.
		 */
		// StudentEntity studentEntity = new StudentEntity();
		// studentEntity.setRollNo(studentModel.getRollNo());

		/**
		 * Case 3: using Builder Pattern
		 */
		 StudentEntity studentEntity = StudentEntity.builder()
		 .name(studentModel.getName())
		 .rollNo(studentModel.getRollNo())
		 .schoolName(studentModel.getSchoolName())
		 .favoriteSubject(studentModel.getFavoriteSubject())
		 .build();

		return studentEntity;
	}
	
	public static StudentModel convertEntityToModel(StudentEntity studentEntity) {
		/**
		 * Case 1: using create object using all parameterized constructor.
		 */
		StudentModel studentModel = new StudentModel(studentEntity.getRollNo(), studentEntity.getName(),
				studentEntity.getSchoolName(), studentEntity.getFavoriteSubject());

		/**
		 * Case 2: using create new blank object.
		 */
		// StudentModel studentModel = new StudentModel();
		// studentModel.setRollNo(studentEntity.getRollNo());

		/**
		 * Case 3: using Builder Pattern
		 */
		// StudentModel studentModel = StudentModel.builder()
		// .name(studentEntity.getName())
		// .rollNo(studentEntity.getRollNo())
		// .schoolName(studentEntity.getSchoolName())
		// .favoriteSubject(studentEntity.getFavoriteSubject())
		// .build();

		return studentModel;
	}
}
