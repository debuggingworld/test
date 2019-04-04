package com.zth.IterationTag;

import javax.servlet.ServletContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.IterationTag;
import javax.servlet.jsp.tagext.Tag;
import java.util.List;

public class UserListTag implements IterationTag {

    private PageContext pageContext = null;
    private User cur;
    private int index = 0;  // 当前索引
    private List<User> users = null;

    @Override
    public void setPageContext(PageContext pageContext) {
        this.pageContext = pageContext;
    }

    @Override
    public void setParent(Tag tag) {

    }

    @Override
    public int doStartTag() throws JspException {

        ServletContext context = pageContext.getServletContext();
        users = (List<User>) context.getAttribute("users");

        if (null != users && users.size()>0){
            cur = users.get(index++);
            return Tag.EVAL_BODY_INCLUDE;

        }else {
            return Tag.SKIP_BODY;
        }

    }

    @Override
    public int doAfterBody() throws JspException {

        if (null != users && index < users.size()){
            this.cur = users.get(index++);
            return IterationTag.EVAL_BODY_AGAIN;
        }else {
            index = 0;
            return  Tag.SKIP_BODY;
        }
    }

    @Override
    public int doEndTag() throws JspException {
        return Tag.EVAL_PAGE;
    }

    @Override
    public void release() {

    }

    @Override
    public Tag getParent() {
        return null;
    }

    public void setCur(User cur) {
        this.cur = cur;
    }


    public User getCur() {
        return cur;
    }

}
