package edu.vn.iuh.fit.temp;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/set-attributes")
public class SetAttributesServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // set application scoped attribute
        req.getServletContext().setAttribute("name", "application scoped attribute");

        // set session scoped attribute
        HttpSession session = req.getSession();
        session.setAttribute("name", "session scoped attribute");

        // set request scoped attribute
        req.setAttribute("name", "request scoped attribute");

        // send redirect to other servlet
        req.getRequestDispatcher("get-attributes").forward(req, resp);
    }
}