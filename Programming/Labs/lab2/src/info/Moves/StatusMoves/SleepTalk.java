package info.Moves.StatusMoves;
import ru.ifmo.se.pokemon.*;

public class SleepTalk extends StatusMove {
    public SleepTalk(){
        super(Type.NORMAL, 0, 0);
    }
    

    @Override
    public void applySelfEffects(Pokemon Pok) {
        // Пользователь выполняет одно из своих собственных движений во время сна.
    }

    @Override
    protected String describe(){
        return "использует Sleep Talk";
    }
}
