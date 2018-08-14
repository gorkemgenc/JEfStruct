package com.github.gorkemgenc.jEfExceptions;

public class JEfListNullException extends RuntimeException{

    public JEfListNullException(){
        super("List should not be null");
    }
}
