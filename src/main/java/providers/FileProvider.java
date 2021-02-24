package providers;

import employees.Employee;
import exceptions.FileReadingException;
import exceptions.FileWritingException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileProvider{

    public Employee getData(String filePath) {
        String[] data;
        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader reader = new BufferedReader(fileReader);
            String line;
            String lineSeparator = "\n";
            StringBuilder fileContent = new StringBuilder();
            while ((line = reader.readLine() ) != null ) {
                fileContent.append(line);
            }
            data = fileContent.toString().split(",");
        } catch (Exception e) {
            throw new FileReadingException("File " + filePath + " can't be reading");
        }
        return Employee.convertDataToEmployee(data);
    }

    public void writeMessage(String filePath, String message) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(filePath, false);
            writer.append(message);
            writer.append("\r\n");
            writer.flush();
        } catch (IOException e) {
            throw new FileWritingException("Message " + message + " can be written in file " + filePath);
        }
    }
}
