package agh.ics.oop;

public class Grass extends AbstractWorldMapElement {

    public Grass(Vector2d grass_pos){
        this.position = grass_pos;
    }

    public String  toString(){
        return "*";
    }



}
