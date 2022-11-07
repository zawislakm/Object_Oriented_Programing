package agh.ics.oop;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
//nie zrobione sa te testy, nie wiem jak
public class SimulationEngineTest {




    @Test
    void runTest(){
        IWorldMap map1 = new RectangularMap(10,10);
        String[] args1 = {"f","b","r","f","b","f","l","b","f","b"};
        MoveDirection[] directions1 = OptionsParser.parse(args1);
        Vector2d[] animals1 = {new Vector2d(2,1),new Vector2d(3,1),new Vector2d(10,1),new Vector2d(100,11)};
        SimulationEngine engine1 = new SimulationEngine(directions1,map1,animals1);
        engine1.run();


        assertEquals(engine1.zwierzaki.get(0).getPosition(),new Vector2d(3,3));
        assertEquals(engine1.zwierzaki.get(0).toString(),"<");

        assertEquals(engine1.zwierzaki.get(1).getPosition(),new Vector2d(3,0));
        assertEquals(engine1.zwierzaki.get(1).toString(),"^");

        assertEquals(engine1.zwierzaki.get(2).getPosition(),new Vector2d(10,1));
        assertEquals(engine1.zwierzaki.get(2).toString(),">");



        IWorldMap map2 = new RectangularMap(8,8); //animal collision test
        String[] args2 = {"f","f","b","f","f","b","f","f","b","f","f","b","f","f","b","f","f","b"};
        MoveDirection[] directions2 = OptionsParser.parse(args2);
        Vector2d[] animals2 = {new Vector2d(8,8),new Vector2d(0,0),new Vector2d(0,5)};
        SimulationEngine engine2 = new SimulationEngine(directions2,map2,animals2);
        engine2.run();



        assertEquals(engine2.zwierzaki.get(0).getPosition(),new Vector2d(8,8));
        assertEquals(engine2.zwierzaki.get(0).toString(),"^");

        assertEquals(engine2.zwierzaki.get(1).getPosition(),new Vector2d(0,2));
        assertEquals(engine2.zwierzaki.get(1).toString(),"^");

        assertEquals(engine2.zwierzaki.get(2).getPosition(),new Vector2d(0,3));
        assertEquals(engine2.zwierzaki.get(2).toString(),"^");


        IWorldMap map3 = new RectangularMap(10,5); //animal collision test
        String[] args3 = {"f","b","r","l","f","f","r","r","f","f","f","f","f","f","f","f"};
        MoveDirection[] directions3 = OptionsParser.parse(args3);
        Vector2d[] animals3 = { new Vector2d(2,2), new Vector2d(3,4) };
        SimulationEngine engine3 = new SimulationEngine(directions3,map3,animals3);
        engine3.run();

        assertEquals(engine3.zwierzaki.get(0).getPosition(),new Vector2d(2,0));
        assertEquals(engine3.zwierzaki.get(0).toString(),"v");

        assertEquals(engine3.zwierzaki.get(1).getPosition(),new Vector2d(3,5));
        assertEquals(engine3.zwierzaki.get(1).toString(),"^");

    }


}
