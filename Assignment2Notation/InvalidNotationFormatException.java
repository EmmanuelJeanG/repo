package application;

public class InvalidNotationFormatException extends RuntimeException {
    
    public InvalidNotationFormatException() {
        super("Notation format is incorrect");
    }

    public InvalidNotationFormatException(String msg) {
        super(msg);
    }
}

