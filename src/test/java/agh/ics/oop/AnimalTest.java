package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AnimalTest {

    @Test // lab3 tests, doesnt work with lab4 up versions
    void moveOutOfMapTest(){
        Animal guineaPig1 = new Animal();// moves to up
        World.runAnimal(new String[]{"f","f","f","f","f"},guineaPig1);
        assertEquals("Position: (2,4), Direction: Północ",guineaPig1.toString());
        assertTrue(guineaPig1.isAt(new Vector2d(2,4)));

        Animal guineaPig2 = new Animal(); //moves to right up corner
        World.runAnimal(new String[]{"f","f","f","r","f","f","f",},guineaPig2);
        assertEquals("Position: (4,4), Direction: Wschód",guineaPig2.toString());
        assertTrue(guineaPig2.isAt(new Vector2d(4,4)));

        Animal guineaPig3 = new Animal(); // moves down
        World.runAnimal(new String[]{"b","b","b","b"},guineaPig3);
        assertEquals("Position: (2,0), Direction: Północ",guineaPig3.toString());
        assertTrue(guineaPig3.isAt(new Vector2d(2,0)));

        Animal guineaPig4 = new Animal(); // moves to left down corner
        World.runAnimal(new String[]{"b", "b", "b", "b", "l", "f", "f", "f", "f"},guineaPig4);
        assertEquals("Position: (0,0), Direction: Zachód",guineaPig4.toString());
        assertTrue(guineaPig4.isAt(new Vector2d(0,0)));

        Animal guineaPig5 = new Animal();
        World.runAnimal(new String[]{"f","f","l","f","l","f"},guineaPig5);
        assertEquals("Position: (1,3), Direction: Południe",guineaPig5.toString());
        assertTrue(guineaPig5.isAt(new Vector2d(1,3)));

    }


}
