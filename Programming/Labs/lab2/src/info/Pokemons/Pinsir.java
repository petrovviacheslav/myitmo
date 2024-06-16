package info.Pokemons;
import info.Moves.PhysicalMoves.Scratch;
import info.Moves.SpecialMoves.Aeroblast;
import info.Moves.SpecialMoves.ThunderShock;
import info.Moves.StatusMoves.SleepTalk;
import ru.ifmo.se.pokemon.*;

public class Pinsir extends Pokemon {
    public Pinsir(String name, int level){
        super(name,level);
        setStats(65,125,100,55,70,85);
        setType(Type.BUG);
        setMove(new ThunderShock(), new Aeroblast(), new Scratch(), new SleepTalk());
    }
}