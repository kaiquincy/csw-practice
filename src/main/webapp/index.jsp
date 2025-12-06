<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="org.example.employee.model.Employee" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee Web Service Test</title>
</head>
<body>
<h2>Employee Web Service - Test Application</h2>

<%
    String message = (String) request.getAttribute("message");
    if (message != null) {
%>
    <p style="color:blue;"><%= message %></p>
<%
    }
%>

<h3>Add / Update Employee</h3>
<form action="employees" method="post">
    <label>ID:</label>
    <input type="number" name="id" required /><br/>

    <label>Name:</label>
    <input type="text" name="name" required /><br/>

    <label>Salary:</label>
    <input type="number" step="0.01" name="salary" required /><br/>

    <button type="submit" name="action" value="add">Add</button>
    <button type="submit" name="action" value="update">Update</button>
</form>

<hr/>

<h3>Employee List</h3>
<table border="1" cellpadding="5">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Salary</th>
    </tr>
    <%
        List<Employee> employees = (List<Employee>) request.getAttribute("employees");
        if (employees != null) {
            for (Employee e : employees) {
    %>
    <tr>
        <td><%= e.getId() %></td>
        <td><%= e.getName() %></td>
        <td><%= e.getSalary() %></td>
    </tr>
    <%
            }
        }
    %>
</table>

</body>
</html>
