package info.pockemons;
import info.moves.*;
import ru.ifmo.se.pokemon.*;

public class Slowbro extends Pokemon {
    public Slowbro(String name, int level){
        super(name,level);
        setStats(95,75,110,100,80,30);
        setType(Type.WATER);
        setMove(new Blizzard(), new Octazooka(), new ThunderWave(), new Substitute());
    }
}