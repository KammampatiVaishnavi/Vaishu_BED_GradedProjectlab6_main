
package com.gl.CollegeFest.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gl.CollegeFest.entity.student;
import com.gl.CollegeFest.service.studentservice;

@Controller
@RequestMapping("students")

public class studentcontroller {
	private static final com.gl.CollegeFest.service.studentservice StudentService = null;
	private final studentservice studentservice;

	public studentcontroller(com.gl.CollegeFest.service.studentservice studentservice) {
		super();
		this.studentservice = studentservice;
	}

	@GetMapping("/list")
	public String liststudent(Model model) {
		List<student> students = studentservice.findAll();
		model.addAttribute("students", students);
		return "student/student-list";
	}

	@GetMapping("/showStudentFormForAdd")
	public String showStudentForm(Model model) {
		student Student = new student(null, null, null, null);

		model.addAttribute("student", Student);
		return "student/student-form";
	}

	@GetMapping("/delete/{id}")
	public String delete(Model model, @PathVariable int id) {
		student Student = studentservice.findById(id);
		StudentService.deleteByid(id);
		return "redirect:/students/list";
	}
	@GetMapping("/studentFormForEdit/{id}")
	public String studentFormForEdit(Model model, @PathVariable int id) {
		student Student = studentservice.findById(id);

		model.addAttribute("student", Student);
		return "student/student-form";
	}
	@PostMapping("/saveStudent")
	public String saveStudent(Model model, @ModelAttribute("student") student Student) {
		StudentService.save(Student);
		return "redirect:/students/list";
	}

}
