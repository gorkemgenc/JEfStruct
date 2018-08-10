package jEfExceptions;

public class JEfStringNullException extends RuntimeException{

    private final String _message;

    public JEfStringNullException(){

        _message = "String is null";
    }

    @Override
    public String getMessage(){

        return _message;
    }
}
