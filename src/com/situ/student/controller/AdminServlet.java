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
import javax.servlet.http.HttpSession;

import com.situ.student.pojo.Admin;
import com.situ.student.pojo.Student;
import com.situ.student.util.JdbcUtil;

public class AdminServlet extends BaseServlet{

	public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1.得到 name和password
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		
		//2.去admin表里面查看
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Admin admin = null;
		try {
			connection = JdbcUtil.getConnection();
			String sql = "select * from admin where name=? and password=?;";
			statement = connection.prepareStatement(sql);
			statement.setString(1, name);
			statement.setString(2, password);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				int id = resultSet.getInt("id");
				String adminName = resultSet.getString("name");
				String adminPassword = resultSet.getString("password");
				admin = new Admin(id, adminName, adminPassword);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(connection, statement, resultSet);
		}
		
		if (admin != null) {
			//把管理员对象放到session里面
			HttpSession session = req.getSession();
			//把admin对象放到session里面
			session.setAttribute("admin", admin);
			resp.sendRedirect(req.getContextPath() + "/student?method=findAll");
		} else {
			resp.sendRedirect(req.getContextPath() + "/login.jsp");
		}
		
	}
}
