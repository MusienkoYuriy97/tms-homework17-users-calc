package by.tms.exeptions.user;

import by.tms.exeptions.user.UserException;

public class UserDataException extends UserException {
    public UserDataException() {
    }

    public UserDataException(String message) {
        super(message);
    }

    public UserDataException(String message, Throwable cause) {
        super(message, cause);
    }
}
