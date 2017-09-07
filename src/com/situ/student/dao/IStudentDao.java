package com.situ.student.dao;

import java.util.List;

import com.situ.student.pojo.Student;

public interface IStudentDao {
	/**
	 * 
	 * @return
	 */
	public abstract List<Student> findAll();
	
	public abstract boolean deleteById(int id);
	
	public abstract boolean add(Student student);
}
