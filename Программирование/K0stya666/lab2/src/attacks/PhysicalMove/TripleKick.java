package lab2.attacks.PhysicalMove;
import ru.ifmo.se.pokemon.*;

public class TripleKick extends PhysicalMove{
    public TripleKick() {
        super(Type.FIGHTING, 10, 90);
    }

    @Override
    protected String describe() {
        return "Покемон сосредотачивает свою энергию и внимание, увеличивая свои шансы нанести критический удар в следующем ходу!";
    }
}
