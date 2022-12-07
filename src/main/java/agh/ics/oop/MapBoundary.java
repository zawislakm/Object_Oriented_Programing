package agh.ics.oop;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class MapBoundary implements IPositionChangeObserver {
    //comperatory do setow
    Comparator<Vector2d> sortOnVector2dX = (vec1, vec2) -> {

        if (vec1.x > vec2.x) {
            return 1;
        } else if (vec1.x < vec2.x) {
            return -1;
        } else {
            if (vec1.y > vec2.y) {
                return 1;
            } else if (vec1.y < vec2.y) {
                return -1;
            }
        }
        return 0;

    };

    Comparator<Vector2d> sortOnVector2dY = (vec1, vec2) -> {
        if (vec1.y > vec2.y) {
            return 1;
        } else if (vec1.y < vec2.y) {
            return -1;
        } else {
            if (vec1.x > vec2.x) {
                return 1;
            } else if (vec1.x < vec2.x) {
                return -1;
            }
        }
        return 0;
    };
    private final SortedSet<Vector2d> setX = new TreeSet<Vector2d>(sortOnVector2dX);
    private final SortedSet<Vector2d> setY = new TreeSet<Vector2d>(sortOnVector2dY);

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        positionRemove(oldPosition);
        positionAdd(newPosition);
    }

    protected void positionAdd(Vector2d newPosition) { //dodaje odrazu do setx i sety
        setX.add(newPosition);
        setY.add(newPosition);
    }

    protected void positionRemove(Vector2d oldPosition) {//usuwa odrazu do setx i sety
        setX.remove(oldPosition);
        setY.remove(oldPosition);
    }

    protected Vector2d getLowerLeft(){
        return new Vector2d(this.setX.first().x,this.setY.first().y); //zwaraca pozycje lewy dol
    }

    protected Vector2d getUpperRight(){
        return new Vector2d(this.setX.last().x,this.setY.last().y); //zwraca pozycja prawy dol
    }
}
