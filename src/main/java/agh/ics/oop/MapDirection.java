package agh.ics.oop;

public enum MapDirection {
    NORTH("Północ", new Vector2d(0, 1)),
    EAST("Wschód", new Vector2d(1, 0)),
    SOUTH("Południe", new Vector2d(0, -1)),
    WEST("Zachód", new Vector2d(-1, 0));

    private final String directionName;
    private final Vector2d defaultVec;

    MapDirection(String kierunek, Vector2d vec) {
        this.directionName = kierunek;
        this.defaultVec = vec;
    }


    public String toString() {

        return this.directionName;
        //used before enum values added
        //return switch (arg) {
        //case NORTH -> "Północ";
        //case SOUTH -> "Południe";
        //case WEST -> "Zachód";
        //case EAST -> "Wschód";
        //};
    }

    public MapDirection next() {
        return switch (this) {
            case EAST -> SOUTH;
            case SOUTH -> WEST;
            case WEST -> NORTH;
            case NORTH -> EAST;
        };
    }


    public MapDirection previous() {
        return switch (this) {
            case EAST -> NORTH;
            case NORTH -> WEST;
            case WEST -> SOUTH;
            case SOUTH -> EAST;
        };
    }

    public Vector2d toUnitVector() {

        return this.defaultVec;
        //used before enum values added
        //return switch (this) {
        //case NORTH -> new Vector2d(0, 1);
        //case EAST -> new Vector2d(1, 0);
        //case SOUTH -> new Vector2d(0, -1);
        //case WEST -> new Vector2d(-1, 0);
        //};
    }
}
