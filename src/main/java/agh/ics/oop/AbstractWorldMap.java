package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

abstract class AbstractWorldMap implements IWorldMap {
    protected List<Animal> zwierzaki = new ArrayList<>();
    protected final MapVisualizer map = new MapVisualizer(this);
    protected Vector2d lowerLeft = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
    protected Vector2d upperRight = new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE);


    public String toString() {
        return map.draw(this.lowerLeft, this.upperRight);

    }
    public boolean isOccupied(Vector2d position){
        return objectAt(position) != null;
    }
    public Object objectAt(Vector2d position) {

        for(Animal animal: zwierzaki){
            if (position.equals(animal.getPosition())){
                return animal;
            }
        }
        return null;
    }

    public boolean place(Animal animal) {
        if (canMoveTo(animal.getPosition())) {
            zwierzaki.add(animal);
            return true;
        }
        return false;
    }

}
