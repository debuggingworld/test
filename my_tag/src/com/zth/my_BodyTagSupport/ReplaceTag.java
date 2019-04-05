package com.zth.my_BodyTagSupport;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.Tag;
import java.io.IOException;

public class ReplaceTag extends BodyTagSupport {

    @Override
    public int doEndTag() throws JspException {

        String name = (String)pageContext.getAttribute("uname", PageContext.APPLICATION_SCOPE);

        String body = bodyContent.getString().replaceAll("#+",name);

        JspWriter out = pageContext.getOut();

        try {
            out.println("<div style = 'width:150px;height:100px;background:#abcdef;color:red'>");
            out.println(body);
            out.println("</div>");
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return super.doEndTag();
    }
}
