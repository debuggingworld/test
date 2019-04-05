package com.upload;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;


@MultipartConfig
@WebServlet("/myUpload")
public class UploadServlet extends HttpServlet {
        @Override
        protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            resp.setContentType("text/html;charset=utf-8");
            req.setCharacterEncoding("utf-8");

            PrintWriter out = resp.getWriter();
            ServletContext context = this.getServletContext();

            Collection<Part> parts = req.getParts();

            try {
                List<UploadResult> uploadResults = FileUploadUtils.uploadFile(parts,context.getRealPath("ups"),1024*1024,"jpg","png","txt");

                out.println("文件上传完成！");

                Iterator<UploadResult> iterator = uploadResults.iterator();

                while (iterator.hasNext()){
                    UploadResult result = iterator.next();

                    System.out.println("oldName::::"+result.getOldName());
                    System.out.println("newName::::"+result.getNewName());
                    System.out.println("mimeType::::"+result.getMimeType());
                }

            } catch (UploadException e) {

                out.println("文件上传失败！");
                e.printStackTrace();
            }
            out.close();
    }
}
