package application;

public class QueueOverflowException extends RuntimeException {
	
    public QueueOverflowException() {
        super("Queue is full");
    }

    public QueueOverflowException(String msg) {
        super(msg);
    }
}

