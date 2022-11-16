package agh.ics.oop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

abstract class AbstractWorldMap implements IWorldMap {
    protected List<Animal> animals = new ArrayList<>();

    private final MapVisualizer map = new MapVisualizer(this);
    protected Vector2d lowerLeft = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
    protected Vector2d upperRight = new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE);


    public String toString() {
        return map.draw(this.lowerLeft, this.upperRight);
    }
    public boolean isOccupied(Vector2d position){
        return objectAt(position) != null;
    }
    public Object objectAt(Vector2d position) {

        for(Animal animal: animals){
            if (position.equals(animal.getPosition())){
                return animal;
            }
        }
        return null;
    }

    public boolean place(Animal animal) {
        if (canMoveTo(animal.getPosition())) {
            animals.add(animal);
            return true;
        }
        return false;
    }

}
