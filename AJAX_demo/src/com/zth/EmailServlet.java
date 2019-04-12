package com.zth;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/email")
public class EmailServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");

        PrintWriter out = resp.getWriter();

        String email = req.getParameter("email");


        // 模拟从数据库读取
        if (email.equals("admin@qq.com")){
            out.print(1);
        }else {
            out.print(0);
        }

    }
}
