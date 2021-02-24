package providers;

import employees.Employee;
import employees.EmployeesType;
import messagegenerator.MessageGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileProviderTest {

    @Test
    void throwException_InvokeGetDataWithIncorrectFilePath () {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            new FileProvider().getData("incorrectFilePath");
        });

        String expected = "File incorrectFilePath can't be reading";
        String actual = exception.getMessage();
        assertEquals(expected, actual);
    }

}