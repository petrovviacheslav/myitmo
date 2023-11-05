package info.Moves.SpecialMoves;
import ru.ifmo.se.pokemon.*;

public class Blizzard extends SpecialMove {
    public Blizzard(){
        super(Type.ICE, 110, 70);
    }
    
    private boolean isFreezed = false;
    @Override
    public void applyOppEffects(Pokemon p) {
        if (Math.random() <= 0.1){
            Effect.freeze(p);
            isFreezed = true;
        }
        // Blizzard наносит урон и имеет 10%-ный шанс заморозить цель. 
        // Он поразит обоих противников в двойном бою или соседних противников в тройном бою. ????
    }

    @Override
    protected String describe(){
        return "использует Blizzard " + ((isFreezed) ? "и freeze цель" : "");
    }
}
