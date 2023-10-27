package vn.iuh.edu.fit.se.demogk_javaee_jpa_mariadb;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iuh.edu.fit.se.service.impl.ProductPriceServiceImpl;
import vn.iuh.edu.fit.se.service.impl.ProductServiceImpl;

import java.io.IOException;

@WebServlet("/servers")
public class ControlServlet extends HttpServlet {

    private ProductServiceImpl productService = new ProductServiceImpl();
    private ProductPriceServiceImpl priceService = new ProductPriceServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action){
            case "listProduct":
            handleProductRequest(req,resp);
                break;
        }




    }

    private void handleProductRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("products", productService.getAll() );
        req.getRequestDispatcher("products.jsp").forward(req,resp);
    }
}
