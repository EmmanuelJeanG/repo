package application;

public class NoUpperAlphaException extends Exception {
    public NoUpperAlphaException() {
        super(Exception_Messages.UPPER_ALPHA_EXCEPTION_MSG);
    }
}

