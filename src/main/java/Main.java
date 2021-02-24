import modes.ModeExecution;

public class Main {

    public static void main(String[] args) {
        String inputType = System.getenv("inputType");
        if (inputType.equals("file")) {
            ModeExecution.fileMod("src/main/resources/inputData", "src/main/resources/outputData");
        }
        else if (inputType.equals("console")) {
            ModeExecution.consoleMod();


        }
    }
}
