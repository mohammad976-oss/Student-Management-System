package com.example.StudentManagement.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.StudentManagement.Entity.Courses;
import com.example.StudentManagement.Service.CoursesService;

@Controller
@RequestMapping("/courses")
public class CoursesController {
	private final CoursesService coursesService;

	public CoursesController(CoursesService coursesService) {
		this.coursesService = coursesService;
	}

	@GetMapping
	public String listCourses(Model model) {
		model.addAttribute("courses", coursesService.findAll());
		return "courses";
	}

	@GetMapping("/new")
	public String createCoursesForm(Model model) {
		model.addAttribute("courses", new Courses());
		return "courses-form";
	}

	@PostMapping
	public String saveCourses(@ModelAttribute("courses") Courses courses) {
		coursesService.save(courses);
		return "redirect:/courses";
	}

	@GetMapping("/edit/{id}")
	public String editCoursesForm(@PathVariable int id, Model model) {
		Courses courses = coursesService.findById(id);
		model.addAttribute("courses", courses);
		return "courses-form";
	}

	@GetMapping("/delete/{id}")
	public String deleteCourses(@PathVariable int id) {
		coursesService.deleteById(id);
		return "redirect:/courses";
	}

}
