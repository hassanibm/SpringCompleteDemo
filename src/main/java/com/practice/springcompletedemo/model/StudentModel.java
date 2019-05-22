package com.practice.springcompletedemo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentModel {

	private int id;
	private int rollNo;
	private String name;
	private String schoolName;
	private String favoriteSubject;
}
