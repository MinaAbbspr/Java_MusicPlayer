package exceptions.failedLogin;

public abstract class FailedLoginException extends Exception{
    public FailedLoginException(String message) {
        super("Failed Login: " + message);
    }
}
