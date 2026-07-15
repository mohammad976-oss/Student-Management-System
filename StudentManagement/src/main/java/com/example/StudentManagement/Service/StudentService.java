package com.example.StudentManagement.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.StudentManagement.Entity.Student;
import com.example.StudentManagement.Repository.StudentRepository;

@Service
public class StudentService {
	private final StudentRepository repository;

	public StudentService(StudentRepository repository) {
		this.repository = repository;
	}

	public void save(Student student) {
		repository.save(student);

	}

	public Student findById(int id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}

	public List<Student> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	public void deleteById(int id) {
		repository.deleteById(id);

	}

}
