package Pokemons;

import Moves.*;
import ru.ifmo.se.pokemon.*;

public class Fearow extends Pokemon {
    public Fearow(String name, int level) {
        super(name, level);
        setType(Type.NORMAL);
        setStats(65, 90, 65, 61, 61, 100);

        setMove(new Drill_Peck(), new Swagger(), new Steel_Wing(),  new Drill_Run());
    }
}