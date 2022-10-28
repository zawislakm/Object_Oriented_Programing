package agh.ics.oop;

import java.lang.reflect.Array;
import java.util.Arrays;

public class World {
    static public void main(String[] args) {

        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
    }

    static public void runAnimal(String[] args, Animal animal) {
        MoveDirection[] directionArray = OptionsParser.parse(args);
        for (MoveDirection todo : directionArray) {
            animal.move(todo);
        }
        System.out.println(animal.toString());
    }
}
