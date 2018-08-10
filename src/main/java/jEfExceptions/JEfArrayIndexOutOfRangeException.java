package jEfExceptions;

public class JEfArrayIndexOutOfRangeException extends RuntimeException{

    private String _message;

    public JEfArrayIndexOutOfRangeException(String message){
        _message = message;
    }

    @Override
    public String getMessage(){
        return _message;
    }
}
