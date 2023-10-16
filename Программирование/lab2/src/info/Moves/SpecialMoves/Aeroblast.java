package info.Moves.SpecialMoves;
import ru.ifmo.se.pokemon.*;

public class Aeroblast extends SpecialMove {
    public Aeroblast(){
        super(Type.FLYING, 100, 95);
    }
    

    // Aeroblast наносит урон и имеет увеличенный коэффициент критического удара (1/8 вместо 1/24).

    @Override
    protected double calcCriticalHit(Pokemon a, Pokemon d) {
        return 3.0 * super.calcCriticalHit(a, d);
    }


    @Override
    protected String describe(){
        return "использует Aeroblast";
    }
}
