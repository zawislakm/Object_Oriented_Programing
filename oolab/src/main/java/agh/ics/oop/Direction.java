package agh.ics.oop;



public class Direction {
    enum DirectionEnum {
        FORWARD,
        BACKWARD,
        RIGHT,
        LEFT
    }
    public static DirectionEnum zmiana(String argument) {

        return switch (argument) {
            case "f" -> DirectionEnum.FORWARD;
            case "b" -> DirectionEnum.BACKWARD;
            case "r" -> DirectionEnum.RIGHT;
            case "l" -> DirectionEnum.LEFT;
            default -> DirectionEnum.FORWARD;
        };

    }

}
