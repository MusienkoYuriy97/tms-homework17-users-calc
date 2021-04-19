package by.tms.exeptions.user;

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
