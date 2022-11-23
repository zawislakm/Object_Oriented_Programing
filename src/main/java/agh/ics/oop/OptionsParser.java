package agh.ics.oop;

import java.util.Arrays;

public class OptionsParser {

    public static MoveDirection[] parse(String[] arg){
        int k = 0; // iterator po tablicy
        MoveDirection[] movedata = new MoveDirection[arg.length];

        for (String s : arg) {

            switch (s) { //k iterator po tablicy
                case "f" -> {movedata[k] = MoveDirection.FORWARD;k++;}
                case "b" -> {movedata[k] = MoveDirection.BACKWARD;k++;}
                case "r" -> {movedata[k] = MoveDirection.RIGHT;k++;}
                case "l" -> {movedata[k] = MoveDirection.LEFT;k++;}
                default -> { throw new IllegalArgumentException(s + " is not legal move specification");}
            }

        }

        movedata = Arrays.copyOfRange(movedata,0,k);

        return movedata;

    }
}
