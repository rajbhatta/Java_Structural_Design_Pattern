package code.solution;

import java.util.ArrayList;
import java.util.List;

public class EmployeeClient {
    public List<Employee> getEmployee(){
        List<Employee> employees=new ArrayList<Employee>();

        Employee employeeFromDB=new EmployeeDb("1","Raj","Bhatta","test@gmail.com");

        employees.add(employeeFromDB);


        EmployeeLdap employeeLdap=new EmployeeLdap("2","Raj-2","Bhatta-2","test2@gmail.com");
        employees.add(new EmployeeAdapter(employeeLdap));

        return employees;
    }
}
