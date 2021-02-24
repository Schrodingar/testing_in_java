package modes;

import messagegenerator.MessageGenerator;
import messagegenerator.MessageType;
import providers.ConsoleProvider;
import providers.FileProvider;

public class ModeExecution {

    public static void consoleMod () {
        MessageGenerator messageGenerator = new MessageGenerator();
        ConsoleProvider consoleProvider = new ConsoleProvider();
        String message = messageGenerator.createMessageByType(MessageType.INFORM, consoleProvider.getData());
        consoleProvider.writeMessage(message);
    }

    public static void fileMod (String inputFile, String outputFile) {
        MessageGenerator messageGenerator = new MessageGenerator();
        FileProvider fileProvider = new FileProvider();
        String message = messageGenerator.createMessageByType(MessageType.INFORM, fileProvider.getData(inputFile));
        fileProvider.writeMessage(outputFile, message);
    }
}
