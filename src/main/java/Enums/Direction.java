package Enums;

public enum Direction {
    LEFT("LEFT"), RIGHT("RIGHT");

    private String _direction;

    private Direction(String direction){
        _direction = direction;
    }

    public String getDirection(){
        return _direction;
    }
}
