package code.solution;

public class EmployeeAdapter implements Employee {

    private EmployeeLdap employeeLdap;

    public EmployeeAdapter(EmployeeLdap employeeLdap) {
    }

    public String getId() {
        return employeeLdap.getCn();
    }

    public String getFirstName() {
        return employeeLdap.getGivenName();
    }

    public String getLastName() {
        return employeeLdap.getSurname();
    }

    public String getEmail() {
        return employeeLdap.getEmail();
    }
}
