package com.github.gorkemgenc.jEfExceptions;

public class JEfVectorNullException extends RuntimeException{

    public JEfVectorNullException(){
        super("Vector should not be null");
    }
}
