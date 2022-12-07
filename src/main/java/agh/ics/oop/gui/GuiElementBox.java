package agh.ics.oop.gui;

import agh.ics.oop.AbstractWorldMap;
import agh.ics.oop.AbstractWorldMapElement;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;


import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class GuiElementBox {

    private final AbstractWorldMapElement worldMapElement;
    private final AbstractWorldMap worldMap; //map have hashmap of already loaded images

    public GuiElementBox( AbstractWorldMap worldMap, AbstractWorldMapElement worldMapElement) {
        this.worldMap = worldMap;
        this.worldMapElement = worldMapElement;

    }

    public VBox getVBox () {
        if (this.worldMapElement == null){ //bedzie przyjmowac object
            return new VBox();
        }
        Image image = null;

        image = this.worldMap.getImage(this.worldMapElement.getImageName());
        // check if image is already loaded, if not -> load it and add to loaded images

        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(20);
        imageView.setFitWidth(20);

        Label label = new Label(this.worldMapElement.getLabel());
        VBox vBox= new VBox(imageView,label);
        vBox.setAlignment(Pos.CENTER);

        return vBox;
    }

}
