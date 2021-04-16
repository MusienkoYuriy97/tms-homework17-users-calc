package by.tms.exeptions.user;

import by.tms.exeptions.user.UserException;

public class UserNotFoundException extends UserException {
    public UserNotFoundException() {
    }

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
