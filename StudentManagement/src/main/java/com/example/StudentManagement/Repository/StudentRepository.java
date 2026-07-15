package com.example.StudentManagement.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.StudentManagement.Entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	List<Student> findByCourses_CoursesId(int coursesId);
}
