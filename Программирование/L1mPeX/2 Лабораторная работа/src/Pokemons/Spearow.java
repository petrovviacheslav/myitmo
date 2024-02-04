package Pokemons;

import Moves.*;
import ru.ifmo.se.pokemon.*;

public class Spearow extends Pokemon {
    public Spearow (String name, int level) {
        super(name, level);
        setType(Type.FLYING);
        setStats(48, 65, 43, 45, 40, 85);

        setMove(new Drill_Peck(), new Swagger(), new Steel_Wing());
    }
}