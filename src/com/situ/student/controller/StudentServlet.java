package com.situ.student.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;

import com.situ.student.pojo.Student;
import com.situ.student.util.JdbcUtil;

public class StudentServlet extends BaseServlet{
	
	
	public void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<Student> list = new ArrayList<>();
		try {
			connection = JdbcUtil.getConnection();
			String sql = "SELECT id,NAME,age,gender,address FROM student;";
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				int age = resultSet.getInt("age");
				String gender = resultSet.getString("gender");
				String address = resultSet.getString("address");
				Student student = new Student(id, name, age, gender, address);
				list.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//放到request域对象中
		req.setAttribute("list", list);
		//转发到页面展示数据
		req.getRequestDispatcher("/student_list.jsp").forward(req, resp);
	}
	
	
	
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
