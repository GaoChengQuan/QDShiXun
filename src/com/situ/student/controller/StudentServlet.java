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

import com.situ.student.pojo.Banji;
import com.situ.student.pojo.Student;
import com.situ.student.util.JdbcUtil;

public class StudentServlet extends BaseServlet{
	public void searchByName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1.根据名字搜索出结果
		String searchName = req.getParameter("name");
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<Student> list = new ArrayList<Student>();
		try {
			connection = JdbcUtil.getConnection();
			String sql = "SELECT id,NAME,age,gender,address FROM student where name like ?;";
			statement = connection.prepareStatement(sql);
			statement.setString(1, "%" + searchName + "%");
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
		} finally {
			JdbcUtil.close(connection, statement, resultSet);
		}
		
		//放到request域对象中
		req.setAttribute("list", list);
		//转发到页面展示数据
		req.getRequestDispatcher("/student_search.jsp").forward(req, resp);
	}
	
	
	public void getAddPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<Banji> list = new ArrayList<Banji>();
		try {
			connection = JdbcUtil.getConnection();
			String sql = "SELECT id,NAME FROM banji;";
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				Banji banji = new Banji(id, name);
				list.add(banji);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(connection, statement, resultSet);
		}
		
		//放到request域对象中
		req.setAttribute("list", list);
		//转发到页面展示数据
		req.getRequestDispatcher("/student_add.jsp").forward(req, resp);
	}
	
	
	
	public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("StudentServlet.add()");
		String name = req.getParameter("name");
		String ageStr = req.getParameter("age");
		String gender = req.getParameter("gender");
		String address = req.getParameter("address");
		int age = 0;
		if (ageStr != null && !ageStr.equals("")) {
			age = Integer.parseInt(ageStr);
		}
		String banjiId = req.getParameter("banjiId");
		
		Student student = new Student(name, age, gender, address);
		System.out.println(student);
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = JdbcUtil.getConnection();
			String sql = "insert into student(name,age,gender,address,banji_id) values(?,?,?,?,?);";
			statement = connection.prepareStatement(sql);
			statement.setString(1, name);
			statement.setInt(2, age);
			statement.setString(3, gender);
			statement.setString(4, address);
			statement.setInt(5, Integer.parseInt(banjiId));
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(connection, statement);
		}
		
		//重定向到查询所有界面
		resp.sendRedirect(req.getContextPath() + "/student?method=findAll");
	}
	
	public void deleteById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("StudentServlet.deleteById()");
		String id = req.getParameter("id");
		System.out.println("id:" + id);
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = JdbcUtil.getConnection();
			String sql = "delete from student where id=?;";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, Integer.parseInt(id));
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(connection, statement);
		}
		//重定向到查询所有界面
		resp.sendRedirect(req.getContextPath() + "/student?method=findAll");
		
	}
	
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
		} finally {
			JdbcUtil.close(connection, statement, resultSet);
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
