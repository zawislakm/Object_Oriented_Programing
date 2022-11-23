package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.List;


public class App  extends Application {

    private AbstractWorldMap mapApp;
    private GridPane gridPane = new GridPane();

    @Override
    public void init() throws Exception {
        try {
            MoveDirection[] directions = new OptionsParser().parse(getParameters().getRaw().toArray(new String[0])); //przejmuje arguemnty, oraz zamienia liste na tablice
            IWorldMap map = new GrassField(10);
            this.mapApp = ((AbstractWorldMap )map);
            Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();
        }
        catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
            System.exit(-1);
        }
    }

    public void start(Stage primaryStage){

        make_gripPane();
        Scene scene = new Scene(gridPane, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void make_gripPane(){

        gridPane.setGridLinesVisible(true);
        Vector2d upperRight = this.mapApp.getUpperRight();
        Vector2d lowerLeft = this.mapApp.getLowerLeft();

        int height_y = upperRight.y - lowerLeft.y + 2; //bo jeszecze pole na dane wykresu
        int width_x = upperRight.x - lowerLeft.x + 2;
        Label label = new Label("PlaceHolder");
        for(int x = 0 ; x < width_x ;x++){
            for(int y = 0 ; y < height_y; y++){


                int true_x = x + lowerLeft.x -1;
                int true_y = upperRight.y -y +1;

                //4przypadki (0,0), (x,0) ,(0,y),pozostale (pola mapy zwierze/grass)
                if(x == 0 && y == 0){
                    label = new Label ("y/x");
                    this.gridPane.add(label,x,y,1,1);
                    gridPane.setHalignment(label, HPos.CENTER);
                }else if (x != 0 && y == 0){
                    label = new Label(Integer.toString(true_x));
                    this.gridPane.add(label,x,y,1,1);
                    gridPane.setHalignment(label, HPos.CENTER);
                }else if (x == 0 && y != 0){
                    label = new Label(Integer.toString(true_y));
                    this.gridPane.add(label,x,y,1,1);
                    gridPane.setHalignment(label, HPos.CENTER);
                }else {
                    Object nowPosition = this.mapApp.objectAt(new Vector2d(true_x,true_y));
                    if(nowPosition != null){
                        label = new Label(nowPosition.toString());
                    }else {
                        label = new Label(" ");
                    }

                    this.gridPane.add(label,x,y,1,1);
                    gridPane.setHalignment(label, HPos.CENTER);
                }
            }
        }

        for (int x = 0; x < width_x; x++) {
            this.gridPane.getColumnConstraints().add(new ColumnConstraints(30));
        }

        for (int y = 0; y < height_y; y++) {
            this.gridPane.getRowConstraints().add(new RowConstraints(30));
        }
    }


}
