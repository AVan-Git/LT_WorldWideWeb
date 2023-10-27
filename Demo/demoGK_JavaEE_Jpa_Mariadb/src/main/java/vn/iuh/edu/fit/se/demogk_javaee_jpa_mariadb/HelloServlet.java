package vn.iuh.edu.fit.se.demogk_javaee_jpa_mariadb;

import java.io.*;

import jakarta.persistence.EntityManager;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.iuh.edu.fit.se.connect.ConnectJpa;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;
    private EntityManager entityManager;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
                // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}