package application;

public class LengthException extends Exception {
    public LengthException() {
        super(Exception_Messages.INVALID_LENGTH_EXCEPTION_MSG);
    }
}

