package org.example.employee.ws;

import org.example.employee.dao.EmployeeDAO;
import org.example.employee.model.Employee;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService(serviceName = "EmployeeWebService")
public class EmployeeWebService {

    private EmployeeDAO dao = new EmployeeDAO();

    @WebMethod
    public Employee[] getEmployees() {
        List<Employee> list = dao.getEmployees();
        return list.toArray(new Employee[0]);
    }

    @WebMethod
    public boolean addEmployee(Employee e) {
        return dao.addEmployee(e);
    }

    @WebMethod
    public boolean updateEmployee(Employee e) {
        return dao.updateEmployee(e);
    }
}
