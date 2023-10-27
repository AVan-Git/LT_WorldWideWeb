<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.se.model.Candidate" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 27/10/2023
  Time: 10:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% List<Candidate> lst = (List<Candidate>) request.getAttribute("candidates"); %>
<h1>List Candidate</h1>
<table style="width: 100%" >
    <thead>
    <tr>
        <td>id</td>
        <td>full name</td>
        <td>phone</td>
        <td>email</td>
        <td>action</td>
    </tr>
    </thead>
    <tbody>
    <% for (Candidate e : lst) { %>
        <tr>
            <td><%= e.getId()%></td>
            <td><%= e.getName()%></td>
            <td><%= e.getPhone()%></td>
            <td><%= e.getEmail()%></td>
            <td><a href="api?action=edit&id<%= e.getId()%>">edit</a></td>
        </tr>

    <% } %>
    </tbody>
</table>

</body>
</html>
