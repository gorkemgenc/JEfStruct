package exceptions;

public class StringNullException extends RuntimeException{

    private String _message;

    public StringNullException(String message){
        _message = message;
    }

    @Override
    public String getMessage(){
        return _message;
    }
}
