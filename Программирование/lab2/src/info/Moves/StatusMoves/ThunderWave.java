package info.Moves.StatusMoves;
import ru.ifmo.se.pokemon.*;

public class ThunderWave extends StatusMove {
    public ThunderWave(){
        super(Type.ELECTRIC, 0, 90);
    }
    
    @Override
    public void applyOppEffects(Pokemon p) {
        Effect eff = new Effect();
        eff.paralyze(p);
        eff.attack(0.25);
        eff.stat(Stat.SPEED, (int)p.getStat(Stat.SPEED) / 2);

        p.addEffect(eff);
        // ThunderWave парализует противника. Парализованные покемоны с вероятностью 25% не 
        // смогут атаковать, а их скорость снижается на 50%.
    }

    @Override
    protected String describe(){
        return "использует Thunder Wave ";
    }
}
