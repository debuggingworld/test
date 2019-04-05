package com.zth.SimpleTag;

import com.zth.IterationTag.User;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserListTag extends SimpleTagSupport {

    @Override
    public void doTag() throws JspException, IOException {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<ul>");
        JspContext jspContext = this.getJspContext();

        List<User> users = (List<User>)jspContext.getAttribute("users", PageContext.APPLICATION_SCOPE);

        if (null!= users && users.size()>0){
            for (User user:users) {
                stringBuilder.append("<li>"+user.getId()+"---"+user.getName()+"---"+user.getSex()+"</li>");
            }
        }
        stringBuilder.append("</ul>");

        this.getJspContext().getOut().println(stringBuilder.toString());
    }
}
