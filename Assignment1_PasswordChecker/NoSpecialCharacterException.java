package application;

public class NoSpecialCharacterException extends Exception {
    public NoSpecialCharacterException() {
        super(Exception_Messages.SPECIAL_CHAR_EXCEPTION_MSG);
    }
}