package info.pockemons;
import info.moves.*;
import ru.ifmo.se.pokemon.*;

public class Magnemite extends Pokemon {
    public Magnemite(String name, int level){
        super(name,level);
        setStats(25,35,70,95,55,45);
        setType(Type.ELECTRIC);
        setMove(new Aeroblast(), new LightScreen());
    }
}