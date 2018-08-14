package com.github.gorkemgenc.jEfExceptions;

public class JEfListSizeNotEqualException extends RuntimeException{

    public JEfListSizeNotEqualException(){
        super("Index out of range. ListSizeNotEqual Exception when comparing two different list");
    }
}
