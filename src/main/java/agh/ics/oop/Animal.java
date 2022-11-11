package agh.ics.oop;

public class Animal extends AbstractWorldMapElement {

    private MapDirection orientation = MapDirection.NORTH;
    private final IWorldMap map;
    public Animal(IWorldMap map){
        this.map = map;
    }
    public Animal(IWorldMap map,Vector2d initialPosition){
        this(map);
        this.position = initialPosition;
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