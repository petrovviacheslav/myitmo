package lab2.attacks.StatusMove;
import ru.ifmo.se.pokemon.*;

public class FocusEnergy extends StatusMove{
    public FocusEnergy() {
        super(Type.NORMAL, 0, 0);
    }

    @Override
    protected String describe() {
        return "Покемон сосредотачивает свою энергию и внимание, увеличивая свои шансы нанести критический удар в следующем ходу!";
    }
}
