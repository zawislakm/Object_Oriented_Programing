package agh.ics.oop;


import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
//siema siema
public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {

    protected Map<Vector2d, AbstractWorldMapElement> mapElements = new HashMap<>();
    private final MapVisualizer map = new MapVisualizer(this);
    protected Vector2d lowerLeft = null;
    protected Vector2d upperRight = null;

    protected Map<String, Image> mapElementsImages = new HashMap<>(); //stores already loaded images


    public String toString() {
        return map.draw(this.lowerLeft, this.upperRight);
    }

    public boolean isOccupied(Vector2d position) {
        return objectAt(position) != null;
    }

    public AbstractWorldMapElement objectAt(Vector2d position) {
        return mapElements.get(position);
    }

    public boolean place(Animal animal) {
        if (canMoveTo(animal.getPosition())) {//tutaj przeniesc dodawanie obserwera
            mapElements.put(animal.getPosition(), animal);
            animal.addObserver(this);
            return true;
        }
        throw new IllegalArgumentException(animal.getPosition().toString() + " is wrong position");

    }

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        AbstractWorldMapElement element = this.mapElements.get(oldPosition);
        this.mapElements.remove(oldPosition);
        this.mapElements.put(newPosition, element);
    }


    public Vector2d getUpperRight() {
        return lowerLeft;
    }

    public Vector2d getLowerLeft() {
        return upperRight;
    }

    public Image getImage(String imageString) {

        if (this.mapElementsImages.get(imageString) == null) {

            try {
                this.mapElementsImages.put(imageString, new Image(new FileInputStream(imageString)));
            } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage());
                System.exit(-1);
            }
        }
        return this.mapElementsImages.get(imageString);
    }

}
