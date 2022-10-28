package agh.ics.oop;

import java.util.List;

public class RectangularMap implements IWorldMap {

    protected Vector2d lowerLeft;
    protected Vector2d upperRight;
    protected MapVisualizer map = new MapVisualizer(this);
    protected List<Animal> animals;
    public RectangularMap(int width, int height) {

        this.lowerLeft = new Vector2d(0,0);
        this.upperRight = new Vector2d(width,height);
        this.animals = SimulationEngine.animals;

    }

    public String toString(){
        return map.draw(this.lowerLeft,this.upperRight);
    }
    @Override
    public boolean canMoveTo(Vector2d position){
        return position.precedes(upperRight) && position.follows(lowerLeft) && !isOccupied(position);
    }
    @Override
    public boolean place(Animal animal){
        return !isOccupied(animal.getPosition());
    }
    @Override
    public boolean isOccupied(Vector2d position){
        return objectAt(position) != null;
    }

    @Override
    public Animal objectAt(Vector2d position) {

        for(Animal animal: animals){
            if (position.equals(animal.getPosition())){
                return animal;
            }
        }
        return null;
    }


}
