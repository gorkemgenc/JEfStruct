package jEfexceptions;

public class VectorNullException extends IllegalArgumentException{

    private String _message;

    public VectorNullException(String message){
        _message = message;
    }

    @Override
    public String getMessage(){
        return _message;
    }
}
