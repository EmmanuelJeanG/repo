package application;

public class UnmatchedException extends Exception {
    public UnmatchedException() {
        super(Exception_Messages.PWD_NO_MATCH_EXCEPTION_MSG);
    }
}

