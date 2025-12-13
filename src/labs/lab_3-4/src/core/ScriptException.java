package core;

public class ScriptException extends Exception {
    public ScriptException() {
        super();
    }

    public ScriptException(String message) {
        super(message);
    }

    public ScriptException(String message, Throwable cause) {
        super(message, cause);
    }
}
