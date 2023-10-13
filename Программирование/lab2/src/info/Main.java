package info;

import ru.ifmo.se.pokemon.*;
import info.Pokemons.*;

public class Main {
    public static void main(String[] args) {
        Battle b = new Battle();
        Claydol p1 = new Claydol("Claydol",2);
        Electabuzz p2 = new Electabuzz("Electabuzz", 2);;
        Magnemite p3 = new Magnemite("Magnemite",2);
        Magneton p4 = new Magneton("Magneton", 2);;
        Pinsir p6 = new Pinsir("Pinsir", 2);
        Slowbro p5 = new Slowbro("Slowbro",2);

        b.addAlly(p1);
        b.addAlly(p2);
        b.addAlly(p3);
        b.addFoe(p4);
        b.addFoe(p5);
        b.addFoe(p6);
        b.go();
    }
}