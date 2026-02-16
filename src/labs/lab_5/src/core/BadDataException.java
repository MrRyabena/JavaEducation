package core;

public class BadDataException extends RuntimeException {
    public BadDataException() {
        super();
    }

    public BadDataException(String message) {
        super(message);
    }

    public BadDataException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public String getMessage() {
        return "Incorrect data: " + super.getMessage();
    }
}
