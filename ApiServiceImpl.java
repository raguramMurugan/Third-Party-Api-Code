package com.hubino.thirdPartyApi.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hubino.thirdPartyApi.entity.Student;


@Service
public class ApiServiceImpl implements ApiService{
	
	String url="http://localhost:8080/fetch";
	String saveurl="http://localhost:8080/save";
	String updateurl="http://localhost:8080/update";
	String deleteurl="http://localhost:8080/delete/{id}";
	
	@Autowired
	RestTemplate rest;

	@Override
	public List<Student> getThirdPartyApi() {
		org.springframework.http.HttpHeaders headers =new org.springframework.http.HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<Student> saveEntity=new HttpEntity<>(headers);
		ResponseEntity<List> responseEntity=rest.exchange(url, HttpMethod.GET,saveEntity,List.class);
		List studendetails=responseEntity.getBody();
		return studendetails;
	}

	@Override
	public Student saveStudentDetails(Student student) {
		
		Student students=new Student();
		students.setAddress(student.getAddress());
		students.setDepartment(student.getDepartment());
		students.setName(student.getName());
		
		
		org.springframework.http.HttpHeaders headers=new org.springframework.http.HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<Student> saveEntity=new HttpEntity<>(headers);
		saveEntity=new HttpEntity<>(students);
		
		ResponseEntity<Student> responseEntity=rest.exchange(saveurl, HttpMethod.POST,saveEntity, Student.class);
		Student studentdata=responseEntity.getBody();
		System.out.println(studentdata);
		return students;
		
	}

	@Override
	public void updateThirdPartyApi(Student student) {
		
		Student students=new Student();
		
		students.setAddress(student.getAddress());
		students.setDepartment(student.getDepartment());
		students.setName(student.getName());
		students.setId(student.getId());
		
		
		org.springframework.http.HttpHeaders headers=new org.springframework.http.HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<Student> updateEntity=new HttpEntity<>(headers);
		updateEntity=new HttpEntity<>(students);
		ResponseEntity<Student> responseEntity=rest.exchange(updateurl,HttpMethod.PUT,updateEntity,Student.class);
		responseEntity.getBody();	
	}
	
	
	@Override
	public void deleteThirdPartyApi(Integer id) {
		
		Map<String, Integer> value=new HashMap<>();
		value.put("id", id);
		rest.delete(deleteurl, value);
	}
	
	




}
