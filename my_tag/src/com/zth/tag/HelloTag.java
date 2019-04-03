package com.zth.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;
import java.io.IOException;

public class HelloTag implements Tag {

    private PageContext pageContext = null;
    private Tag parent = null;
    private int counter=0;

    public HelloTag(){
        System.out.println("HelloTag....");
    }

    @Override
    public void setPageContext(PageContext pageContext) {
        System.out.println("setPageContext.......");
        this.pageContext = pageContext;
    }

    @Override
    public void setParent(Tag tag) {

        System.out.println("setParent......");
        this.parent = tag;
    }

    public void setCounter(int counter) {
        this.counter = counter;
        System.out.println("setCounter..............");
    }


    @Override
    public int doStartTag() throws JspException {
        System.out.println("doStartTag.....");
        return Tag.SKIP_BODY;

    }

    @Override
    public int doEndTag() throws JspException {

        System.out.println("doEndTag");
        JspWriter out = pageContext.getOut();

        for (int i = 0; i < this.getCounter(); i++) {
            try {
                out.println("<h1>hello &nbsp;"+i+"</h1>");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Tag.EVAL_PAGE;
    }

    @Override
    public void release() {

        System.out.println("release...............");
    }
    public int getCounter() {
        return counter;
    }

    @Override
    public Tag getParent() {
        return this.parent;
    }
}
