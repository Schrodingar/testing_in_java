package employees;

import exceptions.ConvertDataToEmployeeException;

import java.util.Arrays;

public class Employee {
    public String getEmployeesType() {
        return employeesType;
    }

    public void setEmployeesType(String employeesType) {
        this.employeesType = employeesType;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private String employeesType;
    private String firstName;
    private String lastName;

    public Employee (String employeesType, String firstName, String lastName) {
        this.employeesType = employeesType;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public static Employee convertDataToEmployee (String[] data) {
        if (data.length != 3) {
            throw new ConvertDataToEmployeeException(Arrays.toString(data) + " can't be converted to Employee");
        }
        return new Employee(data[0].trim(), data[1].trim(), data[2].trim());
    }
}
