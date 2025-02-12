package application;

public class NoDigitException extends Exception {
    public NoDigitException() {
        super(Exception_Messages.DIGIT_EXCEPTION_MSG);
    }
}

