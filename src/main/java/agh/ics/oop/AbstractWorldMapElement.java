package agh.ics.oop;

public abstract class AbstractWorldMapElement {
    protected Vector2d position;

    public Vector2d getPosition(){
        return new Vector2d(position.x,position.y);
    }
}
