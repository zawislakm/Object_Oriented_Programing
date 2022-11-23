package agh.ics.oop;


import java.util.Arrays;

public enum Direction {
    FORWARD,
    BACKWARD,
    RIGHT,
    LEFT;

    // to run in main with starting terminal args
    //Direction[] movedata = Direction.change(args);
    //Direction.run(movedata);
    public static Direction[] change(String[] argument){
        int k = 0; // iterator po tablicy
        Direction[] movedata = new Direction[argument.length];

        for (String s : argument) {

            switch (s) { //k iterator po tablicy
                case "f" -> {movedata[k] = FORWARD;k++;}
                case "b" -> {movedata[k] = BACKWARD;k++;}
                case "r" -> {movedata[k] = RIGHT;k++;}
                case "l" -> {movedata[k] = LEFT;k++;}
                default -> {

                }
            }


        }

        movedata =Arrays.copyOfRange(movedata,0,k);

        return movedata;

    }

    static public void run(Direction[] tab) {
        System.out.println("Start");
        for (Direction arg : tab) {

            String message = switch(arg){
                case FORWARD -> "Zwierzak idzie do przodu";
                case BACKWARD ->  "Zwierzak idze do tyłu";
                case LEFT -> "Zwierzak skreca w lewo";
                case RIGHT -> "Zwierzak skreca w prawo";

            };
            System.out.println(message);
        }
        System.out.println("Stop");
    }


}

