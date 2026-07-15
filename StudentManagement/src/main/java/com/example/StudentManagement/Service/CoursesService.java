package com.example.StudentManagement.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.StudentManagement.Entity.Courses;
import com.example.StudentManagement.Repository.CoursesRepository;

@Service
public class CoursesService {
	private final CoursesRepository coursesRepository;

	public CoursesService(CoursesRepository coursesRepository) {
		this.coursesRepository = coursesRepository;
	}

	public List<Courses> findAll() {
		// TODO Auto-generated method stub
		return coursesRepository.findAll();
	}

	public void save(Courses courses) {
		// TODO Auto-generated method stub
		coursesRepository.save(courses);
	}

	public Courses findById(int id) {
		// TODO Auto-generated method stub
		return coursesRepository.findById(id).orElse(null);
	}

	public void deleteById(int id) {
		// TODO Auto-generated method stub
		coursesRepository.deleteById(id);
		;
	}

}
