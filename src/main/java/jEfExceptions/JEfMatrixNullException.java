package jEfExceptions;

public class JEfMatrixNullException extends RuntimeException{

    private String _message;

    public JEfMatrixNullException(String message){
        _message = message;
    }

    @Override
    public String getMessage(){
        return _message;
    }
}
