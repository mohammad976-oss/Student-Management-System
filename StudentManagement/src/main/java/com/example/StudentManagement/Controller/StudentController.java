package com.example.StudentManagement.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.StudentManagement.Entity.Student;
import com.example.StudentManagement.Service.CoursesService;
import com.example.StudentManagement.Service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {
	private final StudentService studentService;
	private final CoursesService coursesService;

	public StudentController(StudentService studentService, CoursesService coursesService) {
		this.studentService = studentService;
		this.coursesService = coursesService;
	}

	@GetMapping
	public String listStudents(Model model) {
		model.addAttribute("students", studentService.findAll());
		return "students";
	}

	@GetMapping("/new")
	public String createStudentForm(Model model) {
		model.addAttribute("student", new Student());
		model.addAttribute("courses", coursesService.findAll());
		return "student-form";
	}

	@PostMapping
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentService.save(student);
		return "redirect:/students";
	}

	@GetMapping("/edit/{id}")
	public String editStudentForm(@PathVariable int id, Model model) {
		Student student = studentService.findById(id);
		model.addAttribute("student", student);
		model.addAttribute("courses", coursesService.findAll());

		return "student-form";
	}

	@GetMapping("/delete/{id}")
	public String deleteStudent(@PathVariable int id) {
		studentService.deleteById(id);
		return "redirect:/students";
	}

}
