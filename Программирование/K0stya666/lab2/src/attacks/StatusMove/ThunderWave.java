package lab2.attacks.StatusMove;
import ru.ifmo.se.pokemon.*;

public class ThunderWave extends StatusMove{
    public ThunderWave() {
        super(Type.ELECTRIC, 0, 90);
    }

    @Override
    protected String describe() {
        return "Покемон создает грозовую волну, которая поражает цель мощным электрическим разрядом. Эта атака может парализовать цель и снизить ее скорость!";
    }
}
