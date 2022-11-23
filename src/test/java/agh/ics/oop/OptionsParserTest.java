package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OptionsParserTest {

    @Test
    void parseTest() {

        String[] badArgs = {"x", "sad", "ads", "fsa"};
        String[] goodArgs = {"f", "l", "b", "r", "f"};
        String[] emptyArgs = {};
        String[] mixedArgs = {"f", "x","l", "b", "r", "x","f"};


        assertArrayEquals(OptionsParser.parse(emptyArgs),new MoveDirection[]{}); //empty
        assertArrayEquals(OptionsParser.parse(goodArgs), new MoveDirection[]{MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.BACKWARD, MoveDirection.RIGHT, MoveDirection.FORWARD});

        assertThrows(IllegalArgumentException.class, () -> OptionsParser.parse(badArgs)); // all bad args
        assertThrows(IllegalArgumentException.class, () -> OptionsParser.parse(mixedArgs)); // good mixed with bad args
        //assertArrayEquals(OptionsParser.parse(mixedArgs), new MoveDirection[]{MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.BACKWARD, MoveDirection.RIGHT, MoveDirection.FORWARD});

    }//treeset
}
