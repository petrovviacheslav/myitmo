package info.pockemons;
import info.moves.*;
import ru.ifmo.se.pokemon.*;

public class Electabuzz extends Pokemon {
    public Electabuzz(String name, int level){
        super(name,level);
        setStats(65,83,57,95,85,105);
        setType(Type.ELECTRIC);
        setMove(new ThunderShock(), new Aeroblast(), new Scratch());
    }
}