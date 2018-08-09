package jEfExceptions;

public class JEfArrayNullException extends RuntimeException {

    private String _message;

    public JEfArrayNullException(String message){
        _message = message;
    }

    @Override
    public String getMessage(){
        return _message;
    }
}
