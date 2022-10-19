package agh.ics.oop;

public class World {
    static public void main(String[] args) {
        Vector2d position1 = new Vector2d(1, 2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2, 1);
        System.out.println(position2);
        System.out.println(position1.add(position2));

        Animal pies = new Animal();
        Animal Kot = new Animal();
        MoveDirection[] directionArry = OptionsParser.parse(args);
        for(MoveDirection todo: directionArry ){
            Kot.move(todo);
        }
        System.out.println(Kot.toString());
    }
}
