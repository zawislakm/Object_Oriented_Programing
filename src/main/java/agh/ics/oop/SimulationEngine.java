package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine {

    private final IWorldMap map;
    protected List<Animal> zwierzaki = new ArrayList<>();
    protected MoveDirection[] directions;

    public SimulationEngine(MoveDirection[] directions, IWorldMap map, Vector2d[] positions) {
        this.directions = directions;
        this.map = map;
        for (Vector2d position : positions) {
            Animal zwierzak = new Animal(map, position);
            if (map.place(zwierzak)) {
                zwierzaki.add(zwierzak);
            }

        }
    }

    public void run() {
        System.out.println(this.map);
        int len = zwierzaki.size();
        int k = 0;
        for (MoveDirection direction : directions) {
            zwierzaki.get(k % len).move(direction);
            k++;
        }
        System.out.println(this.map);

    }
}
