package jEfExceptions;

public class JEfArrayLengthNotEqualException extends RuntimeException{

    private String _message;

    public JEfArrayLengthNotEqualException(String message){
        _message = message;
    }

    @Override
    public String getMessage(){
        return _message;
    }
}
