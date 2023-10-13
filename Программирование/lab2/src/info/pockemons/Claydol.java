package info.pockemons;
import info.moves.*;
import ru.ifmo.se.pokemon.*;

public class Claydol extends Pokemon {
    public Claydol(String name, int level){
        super(name,level);
        setStats(50,60,95,120,70,70);
        setType(Type.GROUND);
        setMove(new Aeroblast(), new LightScreen(), new Scratch(), new Minimize());
    }
}