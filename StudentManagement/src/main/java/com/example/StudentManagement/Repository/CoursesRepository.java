package com.example.StudentManagement.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.StudentManagement.Entity.Courses;

public interface CoursesRepository extends JpaRepository<Courses, Integer> {

	Optional<Courses> findByCoursesName(String coursesName);

}
