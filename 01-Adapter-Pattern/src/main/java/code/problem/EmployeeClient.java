package code.problem;

import java.util.ArrayList;
import java.util.List;

public class EmployeeClient {
    public List<Employee> getEmployee(){
        List<Employee> employees=new ArrayList<Employee>();

        Employee employeeFromDB=new EmployeeDb("1","Raj","Bhatta","test@gmail.com");

        employees.add(employeeFromDB);


        /**
         * Since our EmployeeLdap is not implementing Employee interface. So,
         *   EmployeeLdap employeeLdap=new EmployeeLdap("2","Raj-2","Bhatta-2","test2@gmail.com");
         *   can not be added to 
         */

        // Since our EmployeeLdap is not implementing Employee interface. So,
       EmployeeLdap employeeLdap=new EmployeeLdap("2","Raj-2","Bhatta-2","test2@gmail.com");
       // It doesn't work
        employees.add(employeeLdap)

        return employees;
    }
}
