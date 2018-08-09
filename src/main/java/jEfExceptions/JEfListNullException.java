package jEfExceptions;

public class JEfListNullException extends RuntimeException{

    private String _message;

    public JEfListNullException(String message){
        _message = message;
    }

    @Override
    public String getMessage(){
        return _message;
    }
}
