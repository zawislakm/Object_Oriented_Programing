package agh.ics.oop;

import java.lang.reflect.Array;
import java.util.Arrays;

public class World {
    static public void main(String[] args) {

        Animal pies = new Animal();
        Animal Kot = new Animal();

        runAnimal(args, Kot);
    }

    static public void runAnimal(String[] args, Animal animal) {
        MoveDirection[] directionArray = OptionsParser.parse(args);
        for (MoveDirection todo : directionArray) {
            animal.move(todo);
        }
        System.out.println(animal.toString());
    }
}
