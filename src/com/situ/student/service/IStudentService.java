package com.situ.student.service;

import java.util.List;

import com.situ.student.pojo.Student;

public interface IStudentService {
	public abstract List<Student> findAll();
}
