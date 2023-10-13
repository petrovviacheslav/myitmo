package info.moves;
import ru.ifmo.se.pokemon.*;

public class Aeroblast extends SpecialMove {
    public Aeroblast(){
        super(Type.FLYING, 100, 95);
    }
    
    @Override
    public void applyOppEffects(Pokemon p) {

        // Aeroblast наносит урон и имеет увеличенный коэффициент критического удара (1/8 вместо 1/24).
    }

    // @Override
    // public void calcCriticalHit(Pokemon p) {
        // return 0.125;
        // Aeroblast наносит урон и имеет увеличенный коэффициент критического удара (1/8 вместо 1/24).
    // }

    @Override
    protected String describe(){
        return "использует Aeroblast ";
    }
}
