package lab2.attacks.SpecialMove;
import ru.ifmo.se.pokemon.*;

public class Blizzard extends SpecialMove{
    public Blizzard () {
        super(Type.ICE,110,70);
    }
    @Override
    protected String describe() {
        return "Покемон вызывает сильную метель с ледяными снежными буранами, нанося урон и имея шанс заморозить цель!";
    }
}
