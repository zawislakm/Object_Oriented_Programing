package agh.ics.oop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap,IPositionChangeObserver {

    protected Map<Vector2d,AbstractWorldMapElement> mapElements = new HashMap<>();
    private final MapVisualizer map = new MapVisualizer(this);
    protected Vector2d lowerLeft = null;
    protected Vector2d upperRight = null;


    public String toString() {
        return map.draw(this.lowerLeft, this.upperRight);
    }
    public boolean isOccupied(Vector2d position){
        return objectAt(position) != null;
    }
    public Object objectAt(Vector2d position) {
        return mapElements.get(position);
    }

    public boolean place(Animal animal) {
        if (canMoveTo(animal.getPosition())) {//tutaj przeniesc dodawanie obserwera
            mapElements.put(animal.getPosition(),animal);
            animal.addObserver(this);
            return true;
        }
        throw new IllegalArgumentException(animal.getPosition().toString() + " is wrong position");

    }
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        AbstractWorldMapElement element = this.mapElements.get(oldPosition);
        this.mapElements.remove(oldPosition);
        this.mapElements.put(newPosition,element);
    }


    public Vector2d getUpperRight(){
        return lowerLeft;
    }

    public Vector2d getLowerLeft(){
        return upperRight;
    }

}
