package jEfExceptions;

public class JEfListSizeNotEqualException extends RuntimeException{
    private String _message;

    public JEfListSizeNotEqualException(String message){
        _message = message;
    }

    @Override
    public String getMessage(){
        return _message;
    }
}
