package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap extends AbstractWorldMap {
    public RectangularMap(int width, int height) {

        this.lowerLeft = new Vector2d(0,0);
        this.upperRight = new Vector2d(width,height);

    }

    public boolean canMoveTo(Vector2d position){
        return position.precedes(this.upperRight) && position.follows(this.lowerLeft) && !isOccupied(position);
    }



}
