package jEfexceptions;

public class ListNullException extends RuntimeException{

    private String _message;

    public ListNullException(String message){
        _message = message;
    }

    @Override
    public String getMessage(){
        return _message;
    }
}
