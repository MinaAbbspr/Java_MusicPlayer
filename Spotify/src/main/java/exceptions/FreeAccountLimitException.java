package exceptions;

public class FreeAccountLimitException extends Exception{
    public FreeAccountLimitException(String message) {
        super(message);
    }
}
