package model.exceptions.failedLogin.type;

import model.exceptions.failedLogin.FailedLoginException;

public class UserNotFoundException extends FailedLoginException {
    public UserNotFoundException(String message) {
        super(message);
    }
    public UserNotFoundException() {
        super("User Not Found");
    }
}
