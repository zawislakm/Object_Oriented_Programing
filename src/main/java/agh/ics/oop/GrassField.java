package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
//checked to dla uzytkownika
//unchecked blad programistyczny
//errora nie da sie lapac
public class GrassField extends AbstractWorldMap {


    private final int range;
    protected List<Grass> grasses = new ArrayList<>();
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
                grasses.add(grass);
                k++;
            }
        }

    }

    public String toString() {

        //getting border of map
        for (Grass grass : grasses) {
            Vector2d temporary = grass.getPosition();
            this.lowerLeft = this.lowerLeft.lowerLeft(temporary);
            this.upperRight = this.upperRight.upperRight(temporary);
        }
        for (Animal animal : animals) {
            Vector2d temporary = animal.getPosition();
            this.lowerLeft = this.lowerLeft.lowerLeft(temporary);
            this.upperRight = this.upperRight.upperRight(temporary);
        }

        return super.toString(); // order importance  Animal <- Grass <- null in drawing

    }

    public boolean canMoveTo(Vector2d position) {
        Object object = objectAt(position);
        if (object instanceof Animal){                  //animal on this position can't move here
            return false;
        }
        if (object instanceof Grass){                   // grass on this position, can move here
            addGrass(1);                             // add new grass somewhere else
            grasses.remove((Grass) object);             // remove grass from this position
            //order important, in other order it was possible to add grass on deleted now position

        }
        return true; // object = grass or null allows to move there
    }




    public Object objectAt(Vector2d position) {

        Object returnObject = null; //assumes there is nothing o this position

        for (Grass grass : grasses) { //check if there is a grass
            if (position.equals(grass.getPosition())) {
                returnObject = grass;
            }
        }

        Object superObject = super.objectAt(position);
        // super objectAt check if there is an animal on this positon
        if (superObject != null){ // it means there an animall
            returnObject = superObject;
        }

        return returnObject; // importance order Animal <- Grass <- null
    }
}
