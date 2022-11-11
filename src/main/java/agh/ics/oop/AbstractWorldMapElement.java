package agh.ics.oop;

abstract class AbstractWorldMapElement implements IMapElement {
    protected Vector2d position;

    public Vector2d getPosition(){
        return new Vector2d(position.x,position.y);
    }
}
