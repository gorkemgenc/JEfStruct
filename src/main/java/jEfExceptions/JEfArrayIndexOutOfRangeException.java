package jEfExceptions;

public class JEfArrayIndexOutOfRangeException extends RuntimeException{

    private String _message;

    public JEfArrayIndexOutOfRangeException(){

        _message = "IndexOutOfRange Exception when comparing two string";
    }

    @Override
    public String getMessage(){
        return _message;
    }
}
