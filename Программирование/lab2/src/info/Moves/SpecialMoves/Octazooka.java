package info.Moves.SpecialMoves;
import info.Pokemons.Claydol;
import ru.ifmo.se.pokemon.*;


public class Octazooka extends SpecialMove {
    public Octazooka(){
        super(Type.WATER, 65, 85);
    }
    


    public void applyOppEffects(Claydol p) {
        if (Math.random() <= 0.5){
            p.setMod(Stat.ACCURACY, -1);
            // Octazooka наносит урон и с вероятностью 50% снижает точность цели на одну ступень.
        }
    }

    @Override
    protected String describe(){
        return "использует Octazooka ";
    }
}
