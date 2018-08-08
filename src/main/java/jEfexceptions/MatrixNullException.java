package jEfexceptions;

public class MatrixNullException extends RuntimeException{

    private String _message;

    public MatrixNullException(String message){
        _message = message;
    }

    @Override
    public String getMessage(){
        return _message;
    }
}
