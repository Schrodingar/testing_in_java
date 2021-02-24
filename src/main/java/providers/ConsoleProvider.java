package providers;

import employees.Employee;

import java.util.Scanner;

public class ConsoleProvider {

    public Employee getData() {
        Scanner in = new Scanner(System.in);
        System.out.println("Please, enter employee data (position, first name, last name) separated by commas: ");
        String input = in.nextLine();
        String[] data = input.split(",");
        in.close();
        return Employee.convertDataToEmployee(data);
    }

    public void writeMessage (String message) {
        System.out.println(message);
    }
}
