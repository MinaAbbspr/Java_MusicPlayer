package exceptions;

public class InvalidFormatException extends Exception{
    public InvalidFormatException(String message) {
        super(message);
    }
    public InvalidFormatException() {
        super("Invalid Format");
    }
}
