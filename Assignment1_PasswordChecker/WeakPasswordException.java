package application;

public class WeakPasswordException extends Exception {
    public WeakPasswordException() {
        super(Exception_Messages.WEAK_PWD_MSG);
    }
}

