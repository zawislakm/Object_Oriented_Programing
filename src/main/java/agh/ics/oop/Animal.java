package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class Animal extends AbstractWorldMapElement {

    private MapDirection orientation = MapDirection.NORTH;
    private final IWorldMap map;
    private final List<IPositionChangeObserver> observersList = new ArrayList<>();
    public Animal(IWorldMap map){
        this.map = map;
        //if (this.map instanceof IPositionChangeObserver){ przeniesiony do place
        //    addObserver((IPositionChangeObserver) this.map);
        //}

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
                Vector2d newPosition = position.add(orientation.toUnitVector());
                if (map.canMoveTo(newPosition)) {
                    Vector2d oldPosition = this.position; //zmiana kolejnosc przy notyfikacji
                    this.position = newPosition;
                    positionChangedA(oldPosition, this.position);

                }

            }
            case BACKWARD -> {
                Vector2d newPosition = position.subtract(orientation.toUnitVector());
                if (map.canMoveTo(newPosition)){
                    Vector2d oldPosition = this.position;//zmiana kolejnosc przy notyfikacji
                    this.position = newPosition;
                    positionChangedA(oldPosition, this.position);
                }

            }
        }
    }
    public void addObserver(IPositionChangeObserver observer){
        this.observersList.add(observer);
    }
    public void removeObserver(IPositionChangeObserver observer){
        this.observersList.remove(observer);
    }

    private void positionChangedA(Vector2d oldPosition, Vector2d newPosition) {
        for (IPositionChangeObserver observer : this.observersList)
            observer.positionChanged(oldPosition, newPosition);
    }


}