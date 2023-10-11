package edu.vn.iuh.fit.listeners;

import jakarta.servlet.ServletContextAttributeEvent;
import jakarta.servlet.ServletContextAttributeListener;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

import java.util.Enumeration;

@WebListener()
public class SimpleServletListener implements ServletContextListener,
        ServletContextAttributeListener, HttpSessionListener {
    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
//        ServletContextAttributeListener.super.attributeAdded(event);
//        System.out.println("\t-----------"+event.getName()+" - "+event.getValue());
        Object s = event.getServletContext().getAttribute("servlet_context");
        System.out.printf("\n--------add---------" + s);
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {
//        ServletContextAttributeListener.super.attributeRemoved(event);
        System.out.printf("\n---------remove--------" + event.getName());
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent event) {
//        ServletContextAttributeListener.super.attributeReplaced(event);
        System.out.printf("\n----Replace---" + event.getName() + "---" + event.getValue());
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContextListener.super.contextInitialized(sce);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContextListener.super.contextDestroyed(sce);
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        System.out.printf("\n------session created---");
        se.getSession().getAttributeNames().asIterator().forEachRemaining(System.out::println);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.printf("\n------session removed---" );
        Enumeration<String> e = se.getSession().getAttributeNames();
        e.asIterator().forEachRemaining(System.out::println);
    }
}