package agh.ics.oop;

public class World {

    static public void main(String[] args) {
        System.out.println("system wystartował");
        Direction.DirectionEnum[] tab = new Direction.DirectionEnum[args.length];

        for(int i = 0; i < args.length;i++){
            tab[i] = Direction.zmiana(args[i]);
        };

        run(tab);
        System.out.println("system zakonczył działanie");
    }

    static public void run(Direction.DirectionEnum[] tab) {
        System.out.println("Start");

        for (Direction.DirectionEnum arg : tab) {

            String message = switch(arg){
                case FORWARD -> "Zwierzak idzie do przodu";
                case BACKWARD ->  "Zwierzak idze do tyłu";
                case LEFT -> "Zwierzak skreca w lewo";
                case RIGHT -> "Zwierzak skreca w prawo";

            };
            System.out.println(message);



        }
        System.out.println("Stop");
    }

}
