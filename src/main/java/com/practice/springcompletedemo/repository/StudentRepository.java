package com.practice.springcompletedemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.springcompletedemo.entity.StudentEntity;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Integer>{

	// Select * from student_entity where rollNo = {rollNo};
	StudentEntity findByRollNo(int rollNo);

}
