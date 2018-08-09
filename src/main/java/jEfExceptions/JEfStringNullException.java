package jEfExceptions;

public class JEfStringNullException extends RuntimeException{

    private String _message;

    public JEfStringNullException(String message){
        _message = message;
    }

    @Override
    public String getMessage(){
        return _message;
    }
}
