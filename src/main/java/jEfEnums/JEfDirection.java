package jEfEnums;

public enum JEfDirection {
    LEFT("LEFT"), RIGHT("RIGHT");

    private String _direction;

    private JEfDirection(String direction){
        _direction = direction;
    }

    public String getDirection(){
        return _direction;
    }
}
