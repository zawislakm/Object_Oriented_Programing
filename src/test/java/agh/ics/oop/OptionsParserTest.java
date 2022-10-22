package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OptionsParserTest {

    @Test
    void parseTest() {

        String[] badArgs = {"xsafa", "sad", "ads", "fsa"};
        String[] goodArgs = {"f", "l", "b", "r", "f"};
        String[] emptyArgs = {};
        String[] mixedArgs = {"f", "x","l", "b", "r", "x","f"};

        assertArrayEquals(OptionsParser.parse(emptyArgs),new MoveDirection[]{});
        assertArrayEquals(OptionsParser.parse(badArgs),new MoveDirection[]{});
        assertArrayEquals(OptionsParser.parse(goodArgs), new MoveDirection[]{MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.BACKWARD, MoveDirection.RIGHT, MoveDirection.FORWARD});
        assertArrayEquals(OptionsParser.parse(mixedArgs), new MoveDirection[]{MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.BACKWARD, MoveDirection.RIGHT, MoveDirection.FORWARD});

    }
}
