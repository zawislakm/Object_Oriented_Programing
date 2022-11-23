package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RectangularMapTest {

    @Test
    void objectAtTest(){
        IWorldMap mapTest = new RectangularMap(10,10);
        Animal guineaPig1 = new Animal(mapTest,new Vector2d(2,2));
        Animal guineaPig2 = new Animal(mapTest,new Vector2d(5,5));
        mapTest.place(guineaPig1);
        mapTest.place(guineaPig2);

        assertEquals(guineaPig1,mapTest.objectAt(new Vector2d(2,2)));
        assertEquals(guineaPig2,mapTest.objectAt(new Vector2d(5,5)));
        assertNull(mapTest.objectAt(new Vector2d(0,0)));
        assertNull(mapTest.objectAt(new Vector2d(100,100)));
    }
    @Test
    void isOccupiedTest(){ // uses object at
        IWorldMap mapTest = new RectangularMap(10,10);
        Animal guineaPig1 = new Animal(mapTest,new Vector2d(2,2));
        Animal guineaPig2 = new Animal(mapTest,new Vector2d(5,5));
        mapTest.place(guineaPig1);
        mapTest.place(guineaPig2);

        assertFalse(mapTest.isOccupied(new Vector2d(0,0)));
        assertFalse(mapTest.isOccupied(new Vector2d(100,111)));
        assertTrue(mapTest.isOccupied(new Vector2d(2,2)));
        assertTrue(mapTest.isOccupied(new Vector2d(5,5)));

    }
    @Test
    void placeTest() { //uses isOccupied
        IWorldMap mapTest = new RectangularMap(10, 10);
        assertTrue(mapTest.place(new Animal(mapTest, new Vector2d(1, 1))));
        assertTrue(mapTest.place(new Animal(mapTest, new Vector2d(2, 2))));
        //assertFalse(mapTest.place(new Animal(mapTest, new Vector2d(1, 1)))); //one animal already there
        assertThrows(IllegalArgumentException.class, () -> mapTest.place(new Animal(mapTest,new Vector2d(1,1)))); //one animal already there
        assertThrows(IllegalArgumentException.class, () -> mapTest.place(new Animal(mapTest, new Vector2d(-10, -10)))); // out of map
        assertThrows(IllegalArgumentException.class, () -> mapTest.place(new Animal(mapTest, new Vector2d(100, 2)))); // out of map


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
}
