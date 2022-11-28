package com.hubino.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hubino.student.entity.Student;
import com.hubino.student.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService service;
	
	@PostMapping("/save")
	public Student saveStudentDetails(@RequestBody Student student)
	{
		return service.saveStudentDetails(student);
	}
	@GetMapping("/fetch")
	public List<Student> fetchStudentDetails()
	{
		return service.fetchStudentDetails();
	}
	@PutMapping("/update")
	public Student updateStudentDetails(@RequestBody Student student)
	{
		return service.updateStudentDetails(student);
	}
	@DeleteMapping("/delete/{id}")
	public String deleteStudentDetails(@PathVariable(name="id") Integer id)
	{
		service.deleteStudentDetails(id);
		return "Selected Id has been deleted Successfully";
	}
	
}
