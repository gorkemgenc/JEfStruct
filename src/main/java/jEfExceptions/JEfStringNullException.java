package jEfExceptions;

public class JEfStringNullException extends RuntimeException{

    public JEfStringNullException(){
        super("String should not be null");
    }
}
