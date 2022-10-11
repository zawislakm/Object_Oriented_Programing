package agh.ics.oop;



public class Direction {
    enum DirectionEnum {
        FORWARD,
        BACKWARD,
        RIGHT,
        LEFT
    }
    public static DirectionEnum zmiana(String argument) {

        DirectionEnum ans = switch (argument) {
            case "f" -> DirectionEnum.FORWARD;
            case "b" -> DirectionEnum.BACKWARD;
            case "r" -> DirectionEnum.RIGHT;
            case "l" -> DirectionEnum.LEFT;
            default -> DirectionEnum.LEFT;
        };
        return ans;

    }


}
