package exceptions;

public class FileWritingException extends RuntimeException {

    public FileWritingException(String text) {
        super(text);
    }
}
