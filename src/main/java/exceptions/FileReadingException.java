package exceptions;

public class FileReadingException extends RuntimeException {

    public FileReadingException(String text) {
        super(text);
    }
}
