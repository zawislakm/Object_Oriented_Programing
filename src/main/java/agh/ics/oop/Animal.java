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
        String toPrint = "";
        toPrint += "Pozycja zwierzaka:";
        toPrint += position.toString();
        toPrint += ", zorientowny jest: ";
        toPrint += orientation.toString();
        return toPrint;
    }

    public boolean isAt(Vector2d position) {
        return position.equals(position); //???
    }

    public  void move(MoveDirection direction) {
        switch (direction) {
            case LEFT -> this.orientation = orientation.previous();
            case RIGHT -> this.orientation = orientation.next();
            case FORWARD -> {
                this.position = position.add(orientation.toUnitVector());
                this.position = position.lowerLeft(new Vector2d(4, 4));
            }
            case BACKWARD -> {
                this.position = position.subtract(orientation.toUnitVector());
                this.position = position.upperRight(new Vector2d(0, 0));
            }//warunki chyba dzialaja
        }
    }

}