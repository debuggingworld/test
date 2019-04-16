package com.zth;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ajax")
public class MyServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		String action = req.getParameter("action");
		
		if("load".equals(action)) {
			this.load(req, resp);
		}else if("getPost".equals(action)) {
			this.getPost(req, resp);
		}
	}
	

	protected void load(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		
		String name = req.getParameter("name");
		
		PrintWriter out = resp.getWriter();
		out.println("Welcome "+name+"!");
		out.close();
	}
	
	protected void getPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		PrintWriter out = resp.getWriter();
		
		String email = req.getParameter("email");
		
		if("admin@qq.com".equals(email)) {
			out.print("1");
		}else {
			out.print("0");
		}
				
		out.close();
	}
	
}
