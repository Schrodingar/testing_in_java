package integrationTests;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import modes.ModeExecution;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;
import rules.RuleTemporaryFolder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class MyStepDef {

    @Rule
    TemporaryFolder temporaryFolder = new TemporaryFolder();

    @Given("Run application in file mod")
    public void runApplicationInFileMod(Map<String, String> exampleTable) {
        String inputFilePath = exampleTable.get("inputFile");
        String outputFilePath = exampleTable.get("outputFile");
        ModeExecution.fileMod(inputFilePath, outputFilePath);
    }

    @Then("Verify, that file contains text")
    public void verifyFileContent(Map<String, String> exampleTable) throws IOException {
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
        RuleTemporaryFolder.writeInTemporaryFolder("Actual - " + actualContent + "\n" + "Expected - " + expectedContent);
        Assert.assertEquals(expectedContent, actualContent);
    }
}
