package agh.ics.oop;

import java.lang.reflect.Array;
import java.util.Arrays;

public class World {
    static public void main(String[] args) {
        Vector2d position1 = new Vector2d(1, 2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2, 1);
        System.out.println(position2);
        System.out.println(position1.add(position2));

        Vector2d out = new Vector2d(-2,0);
        Vector2d back = new Vector2d(0,0);
        Vector2d xd = out.upperRight(back);
        System.out.println(xd.toString());

        Animal pies = new Animal();
        Animal Kot = new Animal();

        runAnimal(args, Kot);

        System.out.println(Kot.toString());
    }

    static public void runAnimal(String[] args, Animal zwierzak) {
        MoveDirection[] directionArray = OptionsParser.parse(args);
        for (MoveDirection todo : directionArray) {
            zwierzak.move(todo);
        }
    }
}
