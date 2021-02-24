import messagegenerator.MessageGenerator;
import messagegenerator.MessageType;
import providers.ConsoleProvider;
import providers.FileProvider;

public class Main {

    public static void main(String[] args) {
        MessageGenerator messageGenerator = new MessageGenerator();
        String message = null;
        if (System.getenv("inputType").equals("file")) {
            FileProvider fileProvider = new FileProvider();
            message = messageGenerator.createMessageByType(MessageType.INFORM, fileProvider.getData("src/main/resources/inputData"));
            fileProvider.writeMessage("src/main/resources/outputData", message);
        }
        else if (System.getenv("inputType").equals("console")) {
            ConsoleProvider consoleProvider = new ConsoleProvider();
            message = messageGenerator.createMessageByType(MessageType.INFORM, consoleProvider.getData());
            consoleProvider.writeMessage(message);


        }
    }
}
