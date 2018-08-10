package jEfExceptions;

public class jEfQueueEmptyException extends RuntimeException {

    public jEfQueueEmptyException() {
        super("Queue should not be empty");
    }
}
