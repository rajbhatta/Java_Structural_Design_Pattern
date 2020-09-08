## Design Consideration ##
- It is very client centric that means legacy component is integrated with client using Adapter.
- Often time integrated with interface but not always the same case

Example
```java
Interger[] arrayofInt=new Integer[]{1,2,3};
List<Integer> listOfInt=Array.asList(arrayofInt);
```
Note: array is adapted into List. Thus, it is adapter design pattern.

## Problem Analysis ##
```js
package code.problem;

public class EmployeeDb implements Employee {

    private String id;
    private String firstName;
    private String lastName;
    private String email;

    public EmployeeDb(String id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }
}

```

```js
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

```

```js
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

```
Let's say we do have Employee coming from EmployeeDb and EmployeeLdap and we are returning employee from EmployeeClient.  Then, EmployeeLdap can't be added in 
```js
List<Employee> employees=new ArrayList<Employee>();
```

Because List must have Employee type interface and EmployeeLdap is not implementing Employee interface. So, to solve this sitation, we ca use ddapter design pattern.
