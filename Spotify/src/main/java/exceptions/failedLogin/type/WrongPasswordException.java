package exceptions.failedLogin.type;

import exceptions.failedLogin.FailedLoginException;

public class WrongPasswordException extends FailedLoginException {
    public WrongPasswordException(String message) {
        super(message);
    }
    public WrongPasswordException() {
        super("Wrong Password");
    }
}
