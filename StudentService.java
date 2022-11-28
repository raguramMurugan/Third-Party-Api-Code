package com.hubino.student.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hubino.student.entity.Student;

@Service
public interface StudentService {

	public Student saveStudentDetails(Student student);

	public List<Student> fetchStudentDetails();

	public Student updateStudentDetails(Student student);

	public void deleteStudentDetails(Integer id);

}
