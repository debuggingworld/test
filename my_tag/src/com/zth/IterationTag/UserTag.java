package com.zth.IterationTag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;
import java.lang.reflect.Field;

public class UserTag implements Tag {

    private PageContext pageContext = null;
    private Tag parent = null;

    public String getPop() {
        return pop;
    }

    public void setPop(String pop) {
        this.pop = pop;
    }

    private String pop = null;

    @Override
    public void setPageContext(PageContext pageContext) {
        this.pageContext = pageContext;
    }

    @Override
    public void setParent(Tag tag) {
        this.parent = tag;
    }

    @Override
    public Tag getParent() {
        return null;
    }

    @Override
    public int doStartTag()  {
        return Tag.SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException{
        if (null != parent && parent instanceof UserListTag){

            UserListTag parentTag = (UserListTag)parent;
            User user = parentTag.getCur();

            Class clazz = user.getClass();

            Field field = null;
            try {
                field = clazz.getDeclaredField(pop);
                if (null != field){
                    field.setAccessible(true);
                    Object val = field.get(user);
                    JspWriter out = pageContext.getOut();
                    out.print(val);
                    out.flush();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return Tag.EVAL_PAGE;
    }

    @Override
    public void release() {

    }
}
