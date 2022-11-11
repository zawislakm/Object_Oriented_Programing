package agh.ics.oop;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SimulationEngineTest {

    @Test
    void runTestRactangularMap(){
        IWorldMap map1 = new RectangularMap(10,10);
        String[] args1 = {"f","b","r","f","b","f","l","b","f","b"};
        MoveDirection[] directions1 = OptionsParser.parse(args1);
        Vector2d[] animals1 = {new Vector2d(2,1),new Vector2d(3,1),new Vector2d(10,1),new Vector2d(100,11)};
        IEngine engine1 = new SimulationEngine(directions1,map1,animals1);
        engine1.run();


        assertEquals(((SimulationEngine) engine1).zwierzaki.get(0).getPosition(),new Vector2d(3,3));
        assertEquals(((SimulationEngine) engine1).zwierzaki.get(0).toString(),"<");

        assertEquals(((SimulationEngine) engine1).zwierzaki.get(1).getPosition(),new Vector2d(3,0));
        assertEquals(((SimulationEngine) engine1).zwierzaki.get(1).toString(),"^");

        assertEquals(((SimulationEngine) engine1).zwierzaki.get(2).getPosition(),new Vector2d(10,1));
        assertEquals(((SimulationEngine) engine1).zwierzaki.get(2).toString(),">");



        IWorldMap map2 = new RectangularMap(8,8); //animal collision test
        String[] args2 = {"f","f","b","f","f","b","f","f","b","f","f","b","f","f","b","f","f","b"};
        MoveDirection[] directions2 = OptionsParser.parse(args2);
        Vector2d[] animals2 = {new Vector2d(8,8),new Vector2d(0,0),new Vector2d(0,5)};
        IEngine engine2 = new SimulationEngine(directions2,map2,animals2);
        engine2.run();



        assertEquals(((SimulationEngine) engine2).zwierzaki.get(0).getPosition(),new Vector2d(8,8));
        assertEquals(((SimulationEngine) engine2).zwierzaki.get(0).toString(),"^");

        assertEquals(((SimulationEngine) engine2).zwierzaki.get(1).getPosition(),new Vector2d(0,2));
        assertEquals(((SimulationEngine) engine2).zwierzaki.get(1).toString(),"^");

        assertEquals(((SimulationEngine) engine2).zwierzaki.get(2).getPosition(),new Vector2d(0,3));
        assertEquals(((SimulationEngine) engine2).zwierzaki.get(2).toString(),"^");


        IWorldMap map3 = new RectangularMap(10,5); //animal collision test
        String[] args3 = {"f","b","r","l","f","f","r","r","f","f","f","f","f","f","f","f"};
        MoveDirection[] directions3 = OptionsParser.parse(args3);
        Vector2d[] animals3 = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine3 = new SimulationEngine(directions3,map3,animals3);
        engine3.run();

        assertEquals(((SimulationEngine) engine3).zwierzaki.get(0).getPosition(),new Vector2d(2,0));
        assertEquals(((SimulationEngine) engine3).zwierzaki.get(0).toString(),"v");

        assertEquals(((SimulationEngine) engine3).zwierzaki.get(1).getPosition(),new Vector2d(3,5));
        assertEquals(((SimulationEngine) engine3).zwierzaki.get(1).toString(),"^");

    }
    @Test
    void runTestGrassField(){
        IWorldMap map1 = new GrassField(10);
        String[] args1 = {"f","b","r","f","b","f","l","b","f","b"};
        MoveDirection[] directions1 = OptionsParser.parse(args1);
        Vector2d[] animals1 = {new Vector2d(2,1),new Vector2d(3,1),new Vector2d(10,1)};
        IEngine engine1 = new SimulationEngine(directions1,map1,animals1);
        engine1.run();


        assertEquals(((SimulationEngine) engine1).zwierzaki.get(0).getPosition(),new Vector2d(3,3));
        assertEquals(((SimulationEngine) engine1).zwierzaki.get(0).toString(),"<");

        assertEquals(((SimulationEngine) engine1).zwierzaki.get(1).getPosition(),new Vector2d(3,-2));
        assertEquals(((SimulationEngine) engine1).zwierzaki.get(1).toString(),"^");

        assertEquals(((SimulationEngine) engine1).zwierzaki.get(2).getPosition(),new Vector2d(12,1));
        assertEquals(((SimulationEngine) engine1).zwierzaki.get(2).toString(),">");



        IWorldMap map2 = new GrassField(8); //animal collision test
        String[] args2 = {"f","f","b","f","f","b","f","f","b","f","f","b","f","f","b","f","f","b"};
        MoveDirection[] directions2 = OptionsParser.parse(args2);
        Vector2d[] animals2 = {new Vector2d(8,8),new Vector2d(0,0),new Vector2d(0,5)};
        IEngine engine2 = new SimulationEngine(directions2,map2,animals2);
        engine2.run();



        assertEquals(((SimulationEngine) engine2).zwierzaki.get(0).getPosition(),new Vector2d(8,14));
        assertEquals(((SimulationEngine) engine2).zwierzaki.get(0).toString(),"^");

        assertEquals(((SimulationEngine) engine2).zwierzaki.get(1).getPosition(),new Vector2d(0,2));
        assertEquals(((SimulationEngine) engine2).zwierzaki.get(1).toString(),"^");

        assertEquals(((SimulationEngine) engine2).zwierzaki.get(2).getPosition(),new Vector2d(0,3));
        assertEquals(((SimulationEngine) engine2).zwierzaki.get(2).toString(),"^");


        IWorldMap map3 = new GrassField(8); //animal collision test
        String[] args3 = {"f","b","r","l","f","f","r","r","f","f","f","f","f","f","f","f"};
        MoveDirection[] directions3 = OptionsParser.parse(args3);
        Vector2d[] animals3 = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine3 = new SimulationEngine(directions3,map3,animals3);
        engine3.run();

        assertEquals(((SimulationEngine) engine3).zwierzaki.get(0).getPosition(),new Vector2d(2,-1));
        assertEquals(((SimulationEngine) engine3).zwierzaki.get(0).toString(),"v");

        assertEquals(((SimulationEngine) engine3).zwierzaki.get(1).getPosition(),new Vector2d(3,7));
        assertEquals(((SimulationEngine) engine3).zwierzaki.get(1).toString(),"^");

    }


}
