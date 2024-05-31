package exceptions.failedLogin.type;

import exceptions.failedLogin.FailedLoginException;

public class WrongPasswordException extends FailedLoginException {
    public WrongPasswordException() {
        super("Wrong Password");
    }
}
