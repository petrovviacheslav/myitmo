package lab2.attacks.SpecialMove;
import ru.ifmo.se.pokemon.*;

public class HydroPump extends SpecialMove{
    public HydroPump() {
        super(Type.WATER, 110, 80);
    }

    @Override
    protected String describe() {
        return "Покемон создает мощную струю воды и направляет ее в сторону цели с огромной силой, нанося значительный урон!";
    }
}
