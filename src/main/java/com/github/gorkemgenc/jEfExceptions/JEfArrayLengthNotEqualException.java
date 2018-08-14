package com.github.gorkemgenc.jEfExceptions;

public class JEfArrayLengthNotEqualException extends RuntimeException{

    public JEfArrayLengthNotEqualException(){
        super("Index out of range. ArrayLengthNotEqual Exception when comparing two array");
    }
}
