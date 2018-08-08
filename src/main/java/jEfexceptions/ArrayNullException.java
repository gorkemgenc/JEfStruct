package jEfexceptions;

public class ArrayNullException extends RuntimeException {

    private String _message;

    public ArrayNullException(String message){
        _message = message;
    }

    @Override
    public String getMessage(){
        return _message;
    }
}
