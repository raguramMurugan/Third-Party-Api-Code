package com.hubino.student.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hubino.student.entity.Student;
import com.hubino.student.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentRepository repo;
	
	@Override
	public Student saveStudentDetails(Student student) {
		return repo.save(student);
		
	}

	@Override
	public List<Student> fetchStudentDetails() {
		
		return repo.findAll();
	}

	@Override
	public Student updateStudentDetails(Student student) {
		
	
		return repo.save(student);
	}

	@Override
	public void deleteStudentDetails(Integer id) {
		repo.deleteById(id);
		
	}
	
	
	

}
