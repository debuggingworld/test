/*
package com.xzy;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/bookinfo")
public class BookInfoServlet extends HttpServlet
{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/xml;charset=utf-8");
		PrintWriter out=resp.getWriter();
		out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		out.println("<books>");
		out.println("<book>");
		out.println("<name>Java入门到精通</name>");
		out.println("<author>张三</author>");
		out.println("</book>");
		out.println("<book>");
		out.println("<name>Java入门到精通1</name>");
		out.println("<author>张三1</author>");
		out.println("</book>");
		out.println(" <book>");
		out.println("<name>Java入门到精通2</name>");
		out.println("<author>张三2</author>");
		out.println("</book>");
		out.println("</books>");
		
		
		out.close();
	}

}
*/
