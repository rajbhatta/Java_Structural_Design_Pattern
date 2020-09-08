package code.problem;

public class EmployeeLdap {
        private String cn;
        private String surname;
        private String givenName;
        private String email;

    public EmployeeLdap(String cn, String surname, String givenName, String email) {
        this.cn = cn;
        this.surname = surname;
        this.givenName = givenName;
        this.email = email;
    }

    public String getCn() {
        return cn;
    }

    public String getSurname() {
        return surname;
    }

    public String getGivenName() {
        return givenName;
    }

    public String getEmail() {
        return email;
    }
}
