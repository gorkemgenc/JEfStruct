package jEfExceptions;

public class JEfVectorNullException extends IllegalArgumentException{

    private String _message;

    public JEfVectorNullException(String message){
        _message = message;
    }

    @Override
    public String getMessage(){
        return _message;
    }
}
