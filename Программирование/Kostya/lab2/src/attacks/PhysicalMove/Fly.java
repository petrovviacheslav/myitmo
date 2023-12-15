package lab2.attacks.PhysicalMove;
import ru.ifmo.se.pokemon.*;

public class Fly extends PhysicalMove {
    public Fly () {
        super(Type.FLYING, 90, 95);
    }

    @Override
    protected String describe() {
        return "Покемон поднимается в воздух и атакует цель сверху!";
    }
}
