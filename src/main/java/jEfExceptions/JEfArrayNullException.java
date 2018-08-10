package jEfExceptions;

public class JEfArrayNullException extends RuntimeException {

    private final String _message;

    public JEfArrayNullException(){

        _message = "Array null exception.";
    }

    @Override
    public String getMessage(){

        return _message;
    }
}
