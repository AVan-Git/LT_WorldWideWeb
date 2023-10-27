<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 27/10/2023
  Time: 6:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="vn.iuh.edu.fit.se.model.Product" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>List Product</title>
</head>
<body>
<% List<Product> lst = (List<Product>) request.getAttribute("products"); %>

<h1>List Product</h1>
<table style="width:100%">
    <thead>
    <tr>
        <td>id</td>
        <td>name</td>
        <td>description</td>
        <td>manuFacturer Name</td>
        <td>unit</td>
        <td>Status</td>
    </tr>
    </thead>
    <tbody>
    <% for (Product e : lst) {%>
    <tr>
        <td><%=e.getId()%>
        </td>
        <td><%=e.getName()%>
        </td>
        <td><%= e.getDescription() %>
        </td>
        <td><%= e.getManufacturerName()%>
        </td>
        <td><%= e.getUnit()%>
        </td>
        <td><%=e.getStatus()%>
        </td>
    </tr>
    <%} %>
    </tbody>
</table>
</body>
</html>
