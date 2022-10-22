package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AnimalTest {

    @Test
    void moveOutOfMapTest(){
        Animal TestPig1 = new Animal();// moves to up
        World.runAnimal(new String[]{"f","f","f","f","f"},TestPig1);
        assertTrue(TestPig1.isAt(new Vector2d(2,4)));

        Animal TestPig2 = new Animal(); //moves to right up corner
        World.runAnimal(new String[]{"f","f","f","r","f","f","f",},TestPig2);
        assertTrue(TestPig2.isAt(new Vector2d(4,4)));

        Animal TestPig3 = new Animal(); // moves down
        World.runAnimal(new String[]{"b","b","b","b"},TestPig3);
        assertTrue(TestPig3.isAt(new Vector2d(2,0)));

        Animal TestPig4 = new Animal(); // moves to left down coner
        World.runAnimal(new String[]{"b", "b", "b", "b", "l", "f", "f", "f", "f"},TestPig4);
        assertTrue(TestPig4.isAt(new Vector2d(0,0)));

        Animal TestPig5 = new Animal();
        World.runAnimal(new String[]{"f","f","l","f","l","f"},TestPig5);
        assertTrue(TestPig5.isAt(new Vector2d(1,3)));


    }
}
