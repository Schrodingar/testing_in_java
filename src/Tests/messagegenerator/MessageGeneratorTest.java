package messagegenerator;

import employees.Employee;
import employees.EmployeesType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MessageGeneratorTest {

    @Test
    void createInformMessage_createCorrectMessage () {
        String expected = new MessageGenerator().createInformMessage(new Employee(EmployeesType.PROGRAMMER.toString(), "Anton", "Ivanov"));
        String actual = "For your information:\nDear Anton Ivanov, we inform you that you should... ";
        assertEquals(expected, actual);
    }

    @Test
    void createAlertMessage_createCorrectMessage () {
        String expected = new MessageGenerator().createAlertMessage(new Employee(EmployeesType.PROGRAMMER.toString(), "Anton", "Ivanov"));
        String actual = "ALERT!\nDear Anton Ivanov, you must... ";
        assertEquals(expected, actual);
    }
}