package model.exceptions.failedLogin.type;

import model.exceptions.failedLogin.FailedLoginException;

public class WrongPasswordException extends FailedLoginException {
    public WrongPasswordException(String message) {
        super(message);
    }
    public WrongPasswordException() {
        super("Wrong Password");
    }
}
