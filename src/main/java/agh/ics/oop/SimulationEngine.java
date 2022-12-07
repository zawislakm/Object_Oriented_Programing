package agh.ics.oop;

import agh.ics.oop.gui.App;
import javafx.application.Platform;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine,Runnable {

    private final IWorldMap map;
    protected List<Animal> animals = new ArrayList<>();
    private MoveDirection[] directions;



    private final List<IPositionChangeObserver> AnimalMoveObserver = new ArrayList<>();

    public SimulationEngine(MoveDirection[] directions,AbstractWorldMap map,Vector2d[] positions){
        this(map,positions);
        this.directions = directions;
    }
    public SimulationEngine(AbstractWorldMap map, Vector2d[] positions) {
        this.map = map;
        for (Vector2d position : positions) {
            Animal animal = new Animal(map, position);
            if (map.place(animal)) {
                animals.add(animal);
                notifyObservers(animal.getPosition(),animal.getPosition());

            }

        }
    }

    public void setDirections(MoveDirection [] directions){
        this.directions = directions;
    }

    @Override
    public void run() {
        moveOnGui(null,null);
        int len = animals.size();
        int k = 0;
        for (MoveDirection direction : directions) {
            Animal pickedAnimal = animals.get(k % len);

            Vector2d oldPosition = pickedAnimal.getPosition();
            pickedAnimal.move(direction);

            Vector2d newPosition = pickedAnimal.getPosition();
            moveOnGui(oldPosition,newPosition);
            k++;
        }


    }

    private void moveOnGui(Vector2d oldPosition, Vector2d newPosition){
        Platform.runLater(() -> {
            notifyObservers(oldPosition,newPosition);
        });

        try{
            int MoveDelay = 1000;
            Thread.sleep(MoveDelay);

        } catch (InterruptedException ex ){
            System.out.println("Simulation interupted");
        }
    }

    private void notifyObservers(Vector2d oldPosition, Vector2d newPosition) { //nie uzywam tego narazie
        for (IPositionChangeObserver observer : this.AnimalMoveObserver) {
            observer.positionChanged(oldPosition, newPosition);
        }
    }

    public void addAnimalMoveObserver(IPositionChangeObserver observer) {
        this.AnimalMoveObserver.add(observer);
    }


}
