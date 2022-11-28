package com.hubino.thirdPartyApi.controller;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hubino.thirdPartyApi.entity.Student;
import com.hubino.thirdPartyApi.service.ApiService;

@RestController
public class ApiController {

	
	@Autowired
	ApiService service;
	
	@GetMapping("/getThirdPartyApi")
	public List<Student> getThirdPartyApi()
	{
		return service.getThirdPartyApi();
	}

	@PostMapping("/saveThirdPartyApi")
	public Student saveStudentDetails(@RequestBody Student student)
	{
		return service.saveStudentDetails(student);
		
	}
	
	@PutMapping("/updateThirdPartyApi")
	public String updateThirdPartyApi(@RequestBody Student student)
	{
		service.updateThirdPartyApi(student);
		return "Fields Updated";
	}

	@DeleteMapping("/deleteThirdPartyApi/{id}")
	public String deleteThirdPartyApi(@PathVariable(name="id") Integer id)
	{
		service.deleteThirdPartyApi(id);
		return "Selected Id has been deleted Successfully";
	}
}
