package jEfExceptions;

public class JEfQueueEmptyException extends RuntimeException {

    public JEfQueueEmptyException() {
        super("Queue should not be empty");
    }
}
