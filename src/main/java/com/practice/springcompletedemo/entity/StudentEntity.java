package com.practice.springcompletedemo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private int rollNo;
	private String name;
	private String schoolName;
	private String favoriteSubject;
}
