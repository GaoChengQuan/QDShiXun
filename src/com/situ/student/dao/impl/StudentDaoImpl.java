package com.situ.student.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.situ.student.dao.IStudentDao;
import com.situ.student.pojo.Student;
import com.situ.student.util.JdbcUtil;

public class StudentDaoImpl implements IStudentDao{

	@Override
	public List<Student> findAll() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Student> list = new ArrayList<Student>();
		try {
			connection = JdbcUtil.getConnection();
			String sql = "SELECT id,NAME,age,gender,address FROM student;";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
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
			JdbcUtil.close(connection, preparedStatement, resultSet);
		}

		return list;
	}

	@Override
	public boolean deleteById(int id) {
		return false;
	}

	@Override
	public boolean add(Student student) {
		return false;
	}
	
}
