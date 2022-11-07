package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap {

    protected Vector2d lowerLeft;
    protected Vector2d upperRight;
    protected MapVisualizer map = new MapVisualizer(this);
    protected  List<Animal> zwierzaki= new ArrayList<>();
    public RectangularMap(int width, int height) {

        this.lowerLeft = new Vector2d(0,0);
        this.upperRight = new Vector2d(width,height);

    }

    @Override
    public String toString(){
        return map.draw(this.lowerLeft,this.upperRight);
    }
    @Override
    public boolean canMoveTo(Vector2d position){
        return position.precedes(this.upperRight) && position.follows(this.lowerLeft) && !isOccupied(position);
    }
    @Override
    public boolean place(Animal animal){
        if (canMoveTo(animal.getPosition())){ // canMove cause sprawdza czy nic nie stoi i czy nie po za mapa
            zwierzaki.add(animal);
            return true;
        }
        return false;
    }
    @Override
    public boolean isOccupied(Vector2d position){
        return objectAt(position) != null;
    }

    @Override
    public Animal objectAt(Vector2d position) {

        for(Animal animal: zwierzaki){
            if (position.equals(animal.getPosition())){
                return animal;
            }
        }
        return null;
    }


}
