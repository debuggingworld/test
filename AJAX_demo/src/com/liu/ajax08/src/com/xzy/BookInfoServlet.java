package com.xzy;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
@WebServlet("/bookinfo")
public class BookInfoServlet extends HttpServlet
{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("applicaiton/json;charset=utf-8");
		PrintWriter out=resp.getWriter();
		List<Book> list=new ArrayList<Book>();
		list.add(new Book("Java开发1","张三1"));
		list.add(new Book("Java开发2","张三2"));
		list.add(new Book("Java开发3","张三3"));
		
	    String re=	JSONObject.toJSONString(list);
		out.println(re);
		out.close();
	}

}
