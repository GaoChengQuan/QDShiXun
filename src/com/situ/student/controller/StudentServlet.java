package com.situ.student.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.situ.student.pojo.Student;
import com.situ.student.service.IStudentService;
import com.situ.student.service.impl.StudentServiceImpl;

public class StudentServlet extends BaseServlet{
	
	
	
	
	
	
	/*@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		IStudentService studentService = new StudentServiceImpl();
		List<Student> list = studentService.findAll();
		for (Student student : list) {
			System.out.println(student);
		}
		//放到request域对象中
		req.setAttribute("list", list);
		req.getRequestDispatcher("/student_list.jsp").forward(req, resp);
	}*/
}
