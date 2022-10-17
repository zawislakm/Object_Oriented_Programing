package agh.ics.oop;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Vector2dTest {

    @Test
    void toStringTest() {
        Vector2d vecTest1 = new Vector2d(2, 1);
        Vector2d vecTest2 = new Vector2d(-3, 2);


        assertEquals(vecTest1.toString(), "(2,1)");
        assertEquals(vecTest2.toString(), "(-3,2)");
    }

    @Test
    void precedesTestTrue() {
        Vector2d vecTest1 = new Vector2d(2, 1); //main vector to tests
        Vector2d vecTest2 = new Vector2d(3, 2);

        assertTrue(vecTest1.precedes(vecTest2)); // 2 <=3 and 1 <= 2
    }

    @Test
    void precedesTestFalse() {
        Vector2d vecTest1 = new Vector2d(2, 1); //main vector to tests
        Vector2d vecTest2 = new Vector2d(-1, -1); //both lower
        Vector2d vecTest3 = new Vector2d(-1, 4); // x lower
        Vector2d vecTest4 = new Vector2d(4, -10); // y lower

        assertFalse(vecTest1.precedes(vecTest2)); // both lower
        assertFalse(vecTest1.precedes(vecTest3)); // x lower
        assertFalse(vecTest1.precedes(vecTest4)); // y lower
    }

    @Test
    void followsTestTrue() {
        Vector2d vecTest1 = new Vector2d(2, 1); //main vector to tests
        Vector2d vecTest2 = new Vector2d(-1, -1);

        assertTrue(vecTest1.follows(vecTest2));
    }

    @Test
    void followsTestFalse() {
        Vector2d vecTest1 = new Vector2d(2, 1); //main vector to tests
        Vector2d vecTest2 = new Vector2d(4, 4); //both higher
        Vector2d vecTest3 = new Vector2d(4, -4); // x higher
        Vector2d vecTest4 = new Vector2d(1, 4); // y higher

        assertFalse(vecTest1.follows(vecTest2)); // both higher
        assertFalse(vecTest1.follows(vecTest3)); // x higher
        assertFalse(vecTest1.follows(vecTest4)); // y higher
    }

    @Test
    void upperRightTest() {
        Vector2d vecTest1 = new Vector2d(2, 1); //main vector to tests
        Vector2d vecTest2 = new Vector2d(4, -1); //x higher
        Vector2d vecTest3 = new Vector2d(1, 3); // y higher
        Vector2d vecTest4 = new Vector2d(2, 1); // same values

        assertEquals(vecTest1.upperRight(vecTest2), new Vector2d(4, 1)); // 2 < 4 and 1 > -1
        assertEquals(vecTest1.upperRight(vecTest3), new Vector2d(2, 3)); // 2 > 1 and 1 < 3
        assertEquals(vecTest1.upperRight(vecTest4), new Vector2d(2, 1)); // 2 == 2 and 1 == 1
    }

    @Test
    void lowerLeftTest() {
        Vector2d vecTest1 = new Vector2d(2, 1); //main vector to tests
        Vector2d vecTest2 = new Vector2d(1, 3); //x lower
        Vector2d vecTest3 = new Vector2d(4, -1); // y lower
        Vector2d vecTest4 = new Vector2d(2, 1); // same values

        assertEquals(vecTest1.lowerLeft(vecTest2), new Vector2d(1, 1)); // 2 > 1 and 1 > 3
        assertEquals(vecTest1.lowerLeft(vecTest3), new Vector2d(2, -1)); // 2 > 4 and 1 > -1
        assertEquals(vecTest1.lowerLeft(vecTest4), new Vector2d(2, 1)); // 2 == 2 and 1 == 1

    }

    @Test
    void addTest() {
        Vector2d vecTest1 = new Vector2d(2, 1); //main vector to tests
        Vector2d vecTest2 = new Vector2d(1, 3);
        Vector2d vecTest3 = new Vector2d(4, -1);
        Vector2d vecTest4 = new Vector2d(2, 1);

        assertEquals(vecTest1.add(vecTest2), new Vector2d(3, 4)); // 2 + 1 = 3 and 1 + 3 = 4
        assertEquals(vecTest1.add(vecTest3), new Vector2d(6, 0)); // 2 + 4 = 6 and 1 + (-1) = 0
        assertEquals(vecTest1.add(vecTest4), new Vector2d(4, 2)); // 2 + 2 = 4 and 1 + 1 = 2
    }

    @Test
    void subtractTest() {
        Vector2d vecTest1 = new Vector2d(2, 1); //main vector to tests
        Vector2d vecTest2 = new Vector2d(1, 3);
        Vector2d vecTest3 = new Vector2d(4, -1);
        Vector2d vecTest4 = new Vector2d(2, 1);

        assertEquals(vecTest1.subtract(vecTest2), new Vector2d(1, -2)); // 2 - 1 = 1 and 1 - 3 = -2
        assertEquals(vecTest1.subtract(vecTest3), new Vector2d(-2, 2)); // 2 - 4 = -2 and 1 - (-1) = 2
        assertEquals(vecTest1.subtract(vecTest4), new Vector2d(0, 0)); // 2 - 2 = 0 and 1 - 1 = 0

    }

    @Test
    void oppositeTest() {
        Vector2d vecTest1 = new Vector2d(-2, -1); // obie ujemne
        Vector2d vecTest2 = new Vector2d(-1, 3); // x ujemny
        Vector2d vecTest3 = new Vector2d(4, -1); // y ujemny
        Vector2d vecTest4 = new Vector2d(2, 1); // obie dodanie

        assertEquals(vecTest1.opposite(), new Vector2d(2, 1)); // -2 -> 2 and -1 -> 1
        assertEquals(vecTest2.opposite(), new Vector2d(1, -3)); // -1 -> 1 and 3 -> -3
        assertEquals(vecTest3.opposite(), new Vector2d(-4, 1)); // 4 -> -4 and -1 -> 1
        assertEquals(vecTest4.opposite(), new Vector2d(-2, -1)); // 2 -> -2 and 1 -> -1
    }

    @Test
    void equalsTest() {
        Vector2d vecTest1 = new Vector2d(2, 1); //main vector to tests
        Vector2d vecTest2 = new Vector2d(2, 1); //same values
        Vector2d vecTest3 = new Vector2d(1, 2); // different values

        assertEquals(vecTest1, vecTest2);
        assertNotEquals(vecTest1, vecTest3);


    }

}
