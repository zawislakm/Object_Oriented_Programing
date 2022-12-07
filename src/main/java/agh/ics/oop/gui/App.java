package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class App extends Application implements IPositionChangeObserver {

    //private AbstractWorldMap mapApp;
    public VBox glowneOkieno = new VBox();
    private AbstractWorldMap map;
    private SimulationEngine engine;

    private HBox startGUI;

    @Override
    public void init(){
        try {
            Vector2d[] positions = new Vector2d[]{new Vector2d(2, 2), new Vector2d(3, 4)};
            this.map = new GrassField(10);
            this.engine = new SimulationEngine(this.map,positions);


        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            System.exit(-1);
        }
    }

    public void start(Stage primaryStage) {
        this.startGUI = createInterface();

        make_gripPane();
        glowneOkieno.getChildren().add(startGUI);
        glowneOkieno.setAlignment(Pos.CENTER);

        primaryStage.setScene(new Scene(glowneOkieno,400,400));
        primaryStage.show();

    }

    public HBox createInterface() {
        TextField directionInput = new TextField();
        Button startButton = new Button();
        HBox biedneGui = new HBox(directionInput, startButton);

        startButton.setOnAction(click -> {
            init();
            MoveDirection[] directions = new OptionsParser().parse(directionInput.getText().split(" "));
            engine.setDirections(directions);
            engine.addAnimalMoveObserver(this);
            Thread engineThread = new Thread(engine);
            engineThread.start();
        });
        return biedneGui;
    }

    public GridPane make_gripPane() {

//        if (this.mapApp instanceof GrassField) {
//            ((GrassField) this.mapApp).updateBorders();
//        }

        GridPane gridPane = new GridPane();
        gridPane.setGridLinesVisible(true);
        Vector2d upperRight = map.getUpperRight();
        Vector2d lowerLeft = map.getLowerLeft();

        int height_y = upperRight.y - lowerLeft.y + 2; //bo jeszecze pole na dane wykresu
        int width_x = upperRight.x - lowerLeft.x + 2;
        Label label = new Label("PlaceHolder");

        for (int x = 0; x < width_x; x++) {
            for (int y = 0; y < height_y; y++) {


                int true_x = x + lowerLeft.x - 1;
                int true_y = upperRight.y - y + 1;

                //4przypadki (0,0), (x,0) ,(0,y),pozostale (pola mapy zwierze/grass)
                if (x == 0 && y == 0) {
                    label = new Label("y/x");
                    gridPane.add(label, x, y, 1, 1);
                    GridPane.setHalignment(label, HPos.CENTER);
                } else if (x != 0 && y == 0) {
                    label = new Label(Integer.toString(true_x));
                    gridPane.add(label, x, y, 1, 1);
                    GridPane.setHalignment(label, HPos.CENTER);
                } else if (x == 0 && y != 0) {
                    label = new Label(Integer.toString(true_y));
                    gridPane.add(label, x, y, 1, 1);
                    GridPane.setHalignment(label, HPos.CENTER);
                } else {

                    GuiElementBox guiElementBox = new GuiElementBox(map, map.objectAt(new Vector2d(true_x, true_y)));
                    VBox vBox = guiElementBox.getVBox();
                    gridPane.add(vBox, x, y, 1, 1);
                    GridPane.setHalignment(vBox, HPos.CENTER);

                }
            }
        }

        for (int x = 0; x < width_x; x++) {
            gridPane.getColumnConstraints().add(new ColumnConstraints(40));
        }

        for (int y = 0; y < height_y; y++) {
            gridPane.getRowConstraints().add(new RowConstraints(40));

        }
        return gridPane;
    }


    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {

        this.glowneOkieno.getChildren().clear();
        this.glowneOkieno.getChildren().add(this.startGUI);
        this.glowneOkieno.getChildren().add(make_gripPane());
    }
}
