package com.situ.student.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * 所有类的父类
 */
public class BaseServlet extends HttpServlet{

	//http://localhost:8080/ShiXun09/student
	//http://localhost:8080/ShiXun09/deleteStudent
	// http://localhost:8080/ShiXun09/student?method=findAll
	// http://localhost:8080/ShiXun09/student?method=delete
	// http://localhost:8080/ShiXun09/banji?method=findAll
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//解决post乱码问题
		req.setCharacterEncoding("utf-8");
		//1.获取请求的method方法
		String methodName = req.getParameter("method");
		//2.获取当前被访问对象的字节码对象
		Class clazz = this.getClass();
		//3.获取当前字节码对象中指定的方法
		if (methodName != null && !methodName.equals("")) {
			Method method;
			try {
				method = clazz.getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
				method.invoke(this, req, resp);
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	
}
