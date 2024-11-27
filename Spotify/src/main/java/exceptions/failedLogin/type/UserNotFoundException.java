package exceptions.failedLogin.type;

import exceptions.failedLogin.FailedLoginException;

public class UserNotFoundException extends FailedLoginException {
    public UserNotFoundException() {
        super("User Not Found");
    }
}
