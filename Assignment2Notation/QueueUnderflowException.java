package application;

public class QueueUnderflowException extends RuntimeException {
    
    public QueueUnderflowException() {
        super("Queue is empty");
    }
    
    public QueueUnderflowException(String msg) {
        super(msg);
    }
}

