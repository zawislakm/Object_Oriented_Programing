package agh.ics.oop;

public class Animal  {

    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2,2);
    private final IWorldMap map;
    public Animal(IWorldMap map){
        this.map = map;
    }
    public Animal(IWorldMap map,Vector2d initialPosition){
        this(map);
        this.position = initialPosition;
    }


    public Animal() {
        this.map = new RectangularMap(5,5);
        this.position = new Vector2d(2,2);
    }

    public String toString() {
        return switch (this.orientation){
            case NORTH -> "^";
            case EAST -> ">";
            case SOUTH -> "v";
            case WEST -> "<";
        };
    }

    public boolean isAt(Vector2d pos) {
        return position.equals(pos);
    }


    public Vector2d getPosition(){
        return new Vector2d(this.position.x,this.position.y); // nie oddaje pozycji
    }

    public void move(MoveDirection direction) {
        switch (direction) {
            case LEFT -> this.orientation = orientation.previous();
            case RIGHT -> this.orientation = orientation.next();
            case FORWARD -> {
                Vector2d temporary = position.add(orientation.toUnitVector());
                if (map.canMoveTo(temporary))
                    this.position = temporary;

            }
            case BACKWARD -> {
                Vector2d temporary = position.subtract(orientation.toUnitVector());
                if (map.canMoveTo(temporary))
                    this.position = temporary;;

            }
        }

    }


}