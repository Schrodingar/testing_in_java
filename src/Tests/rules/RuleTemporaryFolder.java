package rules;

import org.junit.Rule;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class RuleTemporaryFolder {

    @Rule
    static TemporaryFolder temporaryFolder = new TemporaryFolder();


    static private void createTemporaryFolder () {
        try {
            temporaryFolder.create();
        } catch (IOException e) {
            e.printStackTrace();
        }
    };

    static public void writeInTemporaryFolder (String text){
        createTemporaryFolder();
        try {
            File file = temporaryFolder.newFile();
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
