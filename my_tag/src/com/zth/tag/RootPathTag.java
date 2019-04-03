package com.zth.tag;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

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

        


        return Tag.EVAL_PAGE;
    }

    @Override
    public void release() {

    }
}
