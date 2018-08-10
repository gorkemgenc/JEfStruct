package jEfExceptions;

public class JEfListNullException extends RuntimeException{

    private final String _message;

    public JEfListNullException(){

        _message = "List is null exception";
    }

    @Override
    public String getMessage(){

        return _message;
    }
}
