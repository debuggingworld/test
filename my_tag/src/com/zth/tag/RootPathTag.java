package com.zth.tag;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;
import java.io.IOException;

public class RootPathTag implements Tag {
    private PageContext pageContext = null;

    @Override
    public void setPageContext(PageContext pageContext) {

        this.pageContext = pageContext;
    }

    @Override
    public void setParent(Tag tag) {

    }

    @Override
    public Tag getParent() {
        return null;
    }

    @Override
    public int doStartTag() throws JspException {
        return Tag.SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException {

        JspWriter out = pageContext.getOut();

        HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();

        System.out.println("getScheme：：：：："+request.getScheme());
        System.out.println("getServerName::::::::"+request.getServerName());
        System.out.println("getServerPort：：：：："+request.getServerPort());
        System.out.println("getContextPath：：：："+request.getContextPath());

        String path = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
        try {
            out.println(path);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return Tag.EVAL_PAGE;
    }

    @Override
    public void release() {

    }
}
