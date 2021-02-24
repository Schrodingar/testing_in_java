package integrationTests;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import modes.ModeExecution;
import org.junit.Assert;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map;

public class MyStepDef {

    @Given("Run application in file mod")
    public void runApplicationInFileMod(Map<String, String> exampleTable) {
        String inputFilePath = exampleTable.get("inputFile");
        String outputFilePath = exampleTable.get("outputFile");
        ModeExecution.fileMod(inputFilePath, outputFilePath);
    }

    @Then("Verify, that file contains text")
    public void verifyFileContent(Map<String, String> exampleTable) {
        FileReader fileReader = null;
        StringBuilder fileContent = null;
        String lineSeparator = "\n";

        try {
            fileReader = new FileReader(exampleTable.get("outputFile"));
            BufferedReader reader = new BufferedReader(fileReader);
            String line;
            fileContent = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                fileContent.append(line);
                fileContent.append(lineSeparator);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String actualContent = fileContent.toString();
        String expectedContent = exampleTable.get("message");
        System.out.println(expectedContent);
        System.out.println(actualContent);
        Assert.assertEquals(expectedContent, actualContent);
    }
}
