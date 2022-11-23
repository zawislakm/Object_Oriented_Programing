package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GrassFieldTest {

    @Test
    void objectAtTest() {
        IWorldMap mapTest1 = new GrassField(10);
        Animal guineaPig1 = new Animal(mapTest1, new Vector2d(2, 2));
        Animal guineaPig2 = new Animal(mapTest1, new Vector2d(5, 5));
        mapTest1.place(guineaPig1);
        mapTest1.place(guineaPig2);

        assertEquals(guineaPig1, mapTest1.objectAt(new Vector2d(2, 2)));
        assertEquals(guineaPig2, mapTest1.objectAt(new Vector2d(5, 5)));
    }

    @Test
    void canMoveToTest() { //uses place and isOccupied
        IWorldMap mapTest = new RectangularMap(10, 10);
        mapTest.place(new Animal(mapTest, new Vector2d(2, 2))); //
        mapTest.place(new Animal(mapTest, new Vector2d(3, 3)));

        assertTrue(mapTest.canMoveTo(new Vector2d(0, 0)));
        assertTrue(mapTest.canMoveTo(new Vector2d(7,6)));
        assertFalse(mapTest.canMoveTo(new Vector2d(2,2)));
        assertFalse(mapTest.canMoveTo(new Vector2d(3,3)));
        assertFalse(mapTest.canMoveTo(new Vector2d(-10, -1))); //both out of mapTest
        assertFalse(mapTest.canMoveTo(new Vector2d(100,-20)));
    }

    @Test
    void placeTest() {
        IWorldMap mapTest = new GrassField(10);
        assertTrue(mapTest.place(new Animal(mapTest, new Vector2d(1, 1))));
        assertTrue(mapTest.place(new Animal(mapTest, new Vector2d(2, 2))));
        //assertFalse(mapTest.place(new Animal(mapTest, new Vector2d(1, 1)))); //one animal already there - old test
        assertThrows(IllegalArgumentException.class, () -> mapTest.place(new Animal(mapTest,new Vector2d(1,1))));
        assertTrue(mapTest.place(new Animal(mapTest, new Vector2d(-10, -10)))); //minuses allowed
        assertTrue(mapTest.place(new Animal(mapTest, new Vector2d(100, 2)))); // big numbers allowed

    }
}
