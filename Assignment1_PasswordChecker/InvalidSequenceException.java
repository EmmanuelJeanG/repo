package application;

public class InvalidSequenceException extends Exception {
    public InvalidSequenceException() {
        super(Exception_Messages.INVALID_SEQUENCE_EXCEPTION_MSG);
    }
}

