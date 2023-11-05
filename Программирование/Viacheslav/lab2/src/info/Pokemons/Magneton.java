package info.Pokemons;
import info.Moves.PhysicalMoves.Scratch;
import info.Moves.SpecialMoves.Aeroblast;
import info.Moves.StatusMoves.LightScreen;
import ru.ifmo.se.pokemon.*;

public class Magneton extends Pokemon {
    public Magneton(String name, int level){
        super(name,level);
        setStats(50,60,95,120,70,70);
        setType(Type.ELECTRIC);
        setMove(new Aeroblast(), new LightScreen(), new Scratch());
    }
}