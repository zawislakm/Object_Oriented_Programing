package agh.ics.oop;

public class Grass extends AbstractWorldMapElement {

    public Grass(Vector2d grass_pos){
        this.position = grass_pos;
    }

    public String  toString(){
        return "*";
    }

    public String getImageName(){
        return "src/main/resources/grass.png";
    }

    public String getLabel(){
        return "Grass";
    }
}
