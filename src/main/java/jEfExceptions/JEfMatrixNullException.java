package jEfExceptions;

public class JEfMatrixNullException extends RuntimeException{

    public JEfMatrixNullException(){
        super("Matrix should not be null");
    }
}
