package com.zth.IterationTag;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.ArrayList;
import java.util.List;

@WebListener
public class WebInit implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        ServletContext servletContext = sce.getServletContext();

        List<User> users = new ArrayList<>();
        users.add(new User("001","张三1","男"));
        users.add(new User("002","张三2","男"));
        users.add(new User("003","张三3","女"));
        users.add(new User("004","张三4","男"));
        users.add(new User("005","张三5","女"));

        servletContext.setAttribute("users",users);


    }
}
