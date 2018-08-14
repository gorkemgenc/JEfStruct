package com.github.gorkemgenc.jEfExceptions;

public class JEfQueueEmptyException extends RuntimeException {
    public JEfQueueEmptyException(){
        super("Queue should not be null.");
    }
}
