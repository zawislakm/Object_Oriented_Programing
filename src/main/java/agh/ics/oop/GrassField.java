package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
//checked to dla uzytkownika
//unchecked blad programistyczny
//errora nie da sie lapac
public class GrassField extends AbstractWorldMap {


    private final int range;

    public GrassField(int grassQuantity) {
        this.range = (int) (Math.round(Math.sqrt(grassQuantity * 10))); // range of grass blobs spawn
        addGrass(grassQuantity);
    }


    private void addGrass(int n) {
        int k = 0; // iterator
        while (k < n) { //not grasses size because its used letter to add only on grass
            int randomx = (int) (Math.random() * this.range + 1);
            int randomy = (int) (Math.random() * this.range + 1);
            Grass grass = new Grass(new Vector2d(randomx, randomy));
            if (objectAt(grass.getPosition()) == null) {
                mapElements.put(grass.getPosition(),grass);
                k++;
            }
        }
    }
    public String toString() {
        //getting border of map
        this.lowerLeft = this.getLowerLeft();
        this.upperRight = this.getUpperRight();

        return super.toString(); // order importance  Animal <- Grass <- null in drawing

    }

    public boolean canMoveTo(Vector2d position) {
        Object object = objectAt(position);
        if (object instanceof Animal){                  //animal on this position can't move here
            return false;
        }
        if (object instanceof Grass){                   // grass on this position, can move here
            addGrass(1);                             // add new grass somewhere else
            mapElements.remove(((Grass) object).getPosition());             // remove grass from this position
            //order important, in other order it was possible to add grass on deleted now position

        }
        return true; // object = grass or null allows to move there
    }



}
