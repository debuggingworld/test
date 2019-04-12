package com.zth;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hello")
public class Hello extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();

        out.print("<h1 align = 'center'>Welcome Ajax ! </h1>>");

        try{
            // 模拟长时间处理业务
            Thread.sleep(6000);
        }catch (Exception e){
            e.printStackTrace();
        }

        out.println("<center><a href='demo01.jsp'>返回</a></center>");
        out.close();
    }
}
