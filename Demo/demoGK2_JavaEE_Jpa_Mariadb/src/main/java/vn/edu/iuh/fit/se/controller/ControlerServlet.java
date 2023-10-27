package vn.edu.iuh.fit.se.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.se.reponsitories.CandidateReponsitory;
import vn.edu.iuh.fit.se.reponsitories.ExperienceReponsitory;

import java.io.IOException;

@WebServlet("/api")
public class ControlerServlet extends HttpServlet {

    private CandidateReponsitory candidateReponsitory = new CandidateReponsitory();
    private ExperienceReponsitory experienceReponsitory = new ExperienceReponsitory();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action) {
            case "home":
            {
                handleHomeRequest(req,resp);
                break;
            }
            case "list_candidate": {
                handleListCandidate(req,resp);
            }
        }
    }

    private void handleListCandidate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        candidateReponsitory.getAll().forEach(System.out::println);

        req.setAttribute("candidates", candidateReponsitory.getAll());
        req.getRequestDispatcher("candidate.jsp").forward(req,resp);
    }

    private void handleHomeRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("text1", "Hello");
        req.getRequestDispatcher("home.jsp").forward(req, resp);
    }
}
