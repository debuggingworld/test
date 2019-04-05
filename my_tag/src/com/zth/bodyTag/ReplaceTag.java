package com.zth.bodyTag;

import javax.servlet.ServletContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTag;
import javax.servlet.jsp.tagext.Tag;
import java.io.IOException;

public class ReplaceTag implements BodyTag {

    private PageContext pageContext = null;
    private Tag parent = null;
    private BodyContent bodyContent  = null;

    @Override
    public void setPageContext(PageContext pageContext) {
        this.pageContext = pageContext;
    }

    @Override
    public void setParent(Tag tag) {
        this.parent = tag;
    }
    @Override
    public int doStartTag() throws JspException {
        return BodyTag.EVAL_BODY_BUFFERED;
    }

    @Override
    public void setBodyContent(BodyContent bodyContent) {
        this.bodyContent = bodyContent;
    }

    @Override
    public void doInitBody() throws JspException {

    }

    @Override
    public int doAfterBody() throws JspException {
        return 0;
    }

    @Override
    public Tag getParent() {
        return null;
    }



    @Override
    public int doEndTag() throws JspException {
        //String uname =(String) pageContext.getServletContext().getAttribute("uname");
        String uname = (String)pageContext.getAttribute("uname",PageContext.APPLICATION_SCOPE);
        String body = bodyContent.getString();

        body = body.replaceAll("#+",uname);
        JspWriter out = pageContext.getOut();

        try {
            out.println("<div style = 'width:100px;height:100px;background:#abcdef;color:red'>");
            out.println(body);
            out.println("</div>");
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public void release() {

    }
}
