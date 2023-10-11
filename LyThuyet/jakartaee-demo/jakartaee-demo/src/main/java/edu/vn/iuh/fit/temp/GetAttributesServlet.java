package edu.vn.iuh.fit.temp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/get-attributes")
public class GetAttributesServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // get application scoped attribute
        String applicationScope = (String) req.getServletContext().getAttribute("a");

        // get session scoped attribute
        HttpSession session = req.getSession();
        String sessionScope = (String) session.getAttribute("b");

        // get request scoped attribute
        String requestScope = (String) req.getAttribute("c");

        // print response
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.write("<html><body>");
        out.write("<h2>Servlet attributes example: applicationScope, sessionScope and requestScope</h2>");
        out.write("<p>applicationScope: " + applicationScope + "</p>");
        out.write("<p>sessionScope: " + sessionScope + "</p>");
        out.write("<p>requestScope: " + requestScope + "</p>");
    }

}