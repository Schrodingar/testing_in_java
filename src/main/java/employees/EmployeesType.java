package employees;

public enum EmployeesType {
    SALES_MANAGER("Sales Manager"),
    PROGRAMMER("Programmer");

    public final String employeeType;

    private EmployeesType(String employeeType) {
        this.employeeType = employeeType;
    }

    @Override
    public String toString() {
        return employeeType;
    }
}