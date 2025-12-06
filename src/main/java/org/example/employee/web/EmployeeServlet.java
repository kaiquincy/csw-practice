package org.example.employee.web;

import org.example.employee.dao.EmployeeDAO;
import org.example.employee.model.Employee;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class EmployeeServlet extends HttpServlet {

    private EmployeeDAO dao = new EmployeeDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        List<Employee> employees = dao.getEmployees();
        req.setAttribute("employees", employees);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");

        String idStr = req.getParameter("id");
        String name = req.getParameter("name");
        String salaryStr = req.getParameter("salary");

        String message;

        try {
            int id = Integer.parseInt(idStr);
            double salary = Double.parseDouble(salaryStr);

            Employee e = new Employee(id, name, salary);

            boolean ok = false;
            if ("add".equals(action)) {
                ok = dao.addEmployee(e);
            } else if ("update".equals(action)) {
                ok = dao.updateEmployee(e);
            }

            message = ok ? "Operation successful" : "Operation failed";
        } catch (Exception ex) {
            ex.printStackTrace();
            message = "Error: " + ex.getMessage();
        }

        req.setAttribute("message", message);
        doGet(req, resp);
    }
}
