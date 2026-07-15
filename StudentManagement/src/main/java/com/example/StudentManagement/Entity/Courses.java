package com.example.StudentManagement.Entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Courses {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int coursesId;
	private String coursesName;
	@OneToMany(mappedBy = "courses")
	private List<Student> student = new ArrayList<Student>();
}
