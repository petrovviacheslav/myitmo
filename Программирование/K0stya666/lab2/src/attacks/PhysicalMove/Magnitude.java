package lab2.attacks.PhysicalMove;
import ru.ifmo.se.pokemon.*;

public class Magnitude extends PhysicalMove{
    public Magnitude() {
        super(Type.GROUND, 0, 100);
    }

    @Override
    protected String describe() {
        return "Покемон вызывает мощные подземные колебания, в результате чего возникает случайная величина, определяющая силу этой атаки!";
    }
}
