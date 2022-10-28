package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine {

    protected  IWorldMap map;
    protected static List<Animal> animals = new ArrayList<>();
    protected MoveDirection[] directions;

    public SimulationEngine(MoveDirection[] directions, IWorldMap map, Vector2d[] positions){
        this.directions = directions;
        this.map = map;
        for(Vector2d position : positions){
            Animal animal = new Animal(map,position);
            if (map.place(animal)){
                animals.add(animal);
            }
        }
    }

    public void run(){
        System.out.println(this.map);
        int len = animals.size();
        int k = 0;
        for(MoveDirection direction: directions){
            animals.get(k%len).move(direction);
            k++;
        }
        System.out.println(this.map);

    }
}
