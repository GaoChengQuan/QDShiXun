package com.situ.student.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.situ.student.pojo.Admin;

public class LoginFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		String uri = httpServletRequest.getRequestURI();
		String requestPath = uri.substring(uri.lastIndexOf("/")+1, uri.length());
		System.out.println("requestPath:"+requestPath);
		//对于和登陆相关的请求，以及.css和.js文件，直接放行不需要验证
		if (requestPath.equals("login.jsp")
				|| requestPath.equals("login")
				|| uri.contains(".css")
				|| uri.contains(".js")) {
			//不需要登陆验证，直接访问
			chain.doFilter(request, response);
		} else {
			HttpSession session = httpServletRequest.getSession();
			Admin admin = (Admin) session.getAttribute("admin");
			if (admin == null) {
				httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/login.jsp");
			} else {
				chain.doFilter(request, response);
			}
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
