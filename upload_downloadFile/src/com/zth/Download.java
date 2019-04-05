package com.zth;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


@WebServlet("/download")
public class Download extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext context = req.getServletContext();


        String fileName = null!= req.getParameter("fileName")?req.getParameter("fileName"):"";

        String downName = new String (fileName.getBytes("utf-8"),"iso-8859-1");

        resp.setHeader("Content-Disposition","attachment;filename="+downName);

        String path = context.getRealPath("ups/"+fileName);

        FileInputStream inputStream = new FileInputStream(path);

        ServletOutputStream outputStream = resp.getOutputStream();

        byte[] buf = new byte[1024*8];
        int len = -1;

        while ((len = inputStream.read(buf))>0){
            outputStream.write(buf,0,len);
        }

        outputStream.close();
        inputStream.close();

    }
}
