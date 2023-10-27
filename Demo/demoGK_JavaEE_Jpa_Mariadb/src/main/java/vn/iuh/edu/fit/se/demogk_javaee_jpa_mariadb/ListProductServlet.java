package vn.iuh.edu.fit.se.demogk_javaee_jpa_mariadb;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iuh.edu.fit.se.model.Product;
import vn.iuh.edu.fit.se.service.impl.ProductServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/view_products")
public class ListProductServlet extends HttpServlet {
//    @Inject
    private ProductServiceImpl productService = new ProductServiceImpl()    ;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<a href='add_product'>Add Product</a>");
        out.println("<h1>List Product</h1>");
        productService.getAll().forEach(System.out::println);
        List<Product> lst = productService.getAll();
        out.print("<table  width='100%'");
        out.print("<tr><th>Id</th><th>Name</th><th>description</th><th>manufacturerName</th><th>unit</th><th>status</th><th>Edit</th><th>Delete</th></tr>");
        for(Product e:lst){
            System.out.println(e);
            out.print("<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td><td>"+e.getDescription()+"</td> <td>"+e.getManufacturerName()+"</td><td>"+e.getUnit()+"</td><td>"+e.getStatus()+"</td><td><a href='EditServlet?id="+e.getId()+"'>edit</a></td> <td><a href='DeleteServlet?id="+e.getId()+"'>delete</a></td></tr>");
        }
        out.print("</table>");

        out.close();
    }
}
