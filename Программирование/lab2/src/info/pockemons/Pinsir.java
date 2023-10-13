package info.pockemons;
import info.moves.*;
import ru.ifmo.se.pokemon.*;

public class Pinsir extends Pokemon {
    public Pinsir(String name, int level){
        super(name,level);
        setStats(65,125,100,55,70,85);
        setType(Type.BUG);
        setMove(new ThunderShock(), new Aeroblast(), new Scratch(), new SleepTalk());
    }
}