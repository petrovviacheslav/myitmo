package info.moves;
import ru.ifmo.se.pokemon.*;

public class Minimize extends StatusMove {
    public Minimize(){
        super(Type.NORMAL, 0, 0);
    }
    
    
    @Override
    public void applySelfEffects(Pokemon p) {
        p.setMod(Stat.EVASION, 2);
        // Minimize увеличивает уклонение пользователя на две ступени, тем 
        // самым затрудняя попадание в пользователя.
    }

    @Override
    protected String describe(){
       return "использует Minimize ";
    }
}
