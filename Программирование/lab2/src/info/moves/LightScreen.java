package info.moves;
import ru.ifmo.se.pokemon.*;

public class LightScreen extends StatusMove {
    public LightScreen(){
        super(Type.PSYCHIC, 0, 0);
    }
    

    @Override
    public void applySelfEffects(Pokemon p) {
        Effect eff = new Effect();
        eff.stat(Stat.SPECIAL_ATTACK, (int)p.getStat(Stat.SPECIAL_ATTACK) / 2);
        eff.turns(5);

        p.addEffect(eff);
        // LightScreen уменьшает урон от специальных атак на 50% на 5 ходов. 
        // Его эффекты распространяются на всех покемонов на стороне пользователя поля. ?????
    }

    @Override
    protected String describe(){
        return "использует Light Screen";
    }
}
