package FunctionalInterfaces;

import human.*;
import premises.Rocket;

public interface TakeoffFunction {

    default String takeoff(Rocket rocket){

        Person donut = new Donut("");

        return "ракета взлетела";
    };


}
