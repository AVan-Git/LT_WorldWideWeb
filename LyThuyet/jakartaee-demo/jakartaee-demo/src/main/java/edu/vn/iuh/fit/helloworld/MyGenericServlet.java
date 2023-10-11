package edu.vn.iuh.fit.helloworld;

import jakarta.servlet.*;

import java.io.IOException;

//@WebServlet(name = "myGenericServlet", value = "/myGenericServlet")
public class MyGenericServlet extends GenericServlet {
    private String initParam;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        initParam = config.getInitParameter("Greetings");
    }

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        ServletContext ctx = this.getServletContext();
        String name = ctx.getInitParameter("name");
        response.getWriter().println(initParam + " GenericServlet by " + name);
    }
}
