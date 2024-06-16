package Pokemons;

import Moves.*;
import ru.ifmo.se.pokemon.*;

public class Flygon extends Pokemon {
    public Flygon(String name, int level) {
        super(name, level);
        setType(Type.GROUND);
        setStats(80, 100, 100, 80, 80, 90);

        setMove(new Mud_Slap(), new Rest(), new Boomburst(), new Flamethrower());
    }
}