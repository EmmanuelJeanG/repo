package application;

public class NoLowerAlphaException extends Exception {
    public NoLowerAlphaException() {
        super(Exception_Messages.LOWER_ALPHA_EXCEPTION_MSG);
    }
}

