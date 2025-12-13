package transport;

public class BreakException extends Exception {
    public BreakException() {
        super();
    }

    public BreakException(String message) {
        super(message);
    }

    public BreakException(String message, Throwable cause) {
        super(message, cause);
    }
}
