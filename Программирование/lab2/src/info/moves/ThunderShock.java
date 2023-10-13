package info.moves;
import ru.ifmo.se.pokemon.*;

public class ThunderShock extends SpecialMove {
    public ThunderShock(){
        super(Type.ELECTRIC, 40, 100);
    }
    
    private boolean isParalyzed = false;
    @Override
    public void applyOppEffects(Pokemon p) {
        if (Math.random() <= 0.1){
            Effect.paralyze(p);
            isParalyzed = true;
        }
        // ThunderShock наносит урон и с вероятностью 10% парализует цель.
    }

    @Override
    protected String describe(){
        return "использует ThunderShock " + ((isParalyzed) ? "и paralyze цель" : "");
    }
}
