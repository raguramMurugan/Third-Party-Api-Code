package com.hubino.thirdPartyApi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hubino.thirdPartyApi.entity.Student;



@Service
public interface ApiService {

	public List<Student> getThirdPartyApi();

	public Student saveStudentDetails(Student student);

	public void updateThirdPartyApi(Student student);

	public void deleteThirdPartyApi(Integer id);

	
	

	

}
