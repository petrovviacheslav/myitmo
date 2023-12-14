package lab2.attacks.StatusMove;
import ru.ifmo.se.pokemon.*;

public class LightScreen extends StatusMove{
    public LightScreen() {
        super(Type.PSYCHIC, 0, 0);
    }

    @Override
    protected String describe() {
        return "Покемон создает защитный световой барьер, который снижает урон от специальных атак противников в следующие несколько ходов!";
    }
}
