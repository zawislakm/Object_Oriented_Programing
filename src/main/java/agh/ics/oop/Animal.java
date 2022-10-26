package agh.ics.oop;

import java.net.NoRouteToHostException;

public class Animal {

    private MapDirection orientation;
    private Vector2d position;

    public Animal() {
        orientation = MapDirection.NORTH;
        position = new Vector2d(2, 2);
    }

    public String toString() {
        return "Position: " + position.toString() + ", Direction: " + orientation.toString();
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
                if (temporary.precedes(new Vector2d(4, 4)) && temporary.follows(new Vector2d(0, 0)))
                    this.position = temporary;

            }
            case BACKWARD -> {
                Vector2d temporary = position.subtract(orientation.toUnitVector());
                if (temporary.precedes(new Vector2d(4, 4)) && temporary.follows(new Vector2d(0, 0)))
                    this.position = temporary;

            }
        }

    }


}