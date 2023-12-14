package lab2.attacks.SpecialMove;
import ru.ifmo.se.pokemon.*;

public class Aeroblast extends SpecialMove{
    public Aeroblast() {
        super(Type.FLYING, 100, 95);
    }

    @Override
    protected String describe() {
        return "Покемон выпускает мощный взрыв воздушных вихрей, поражая цель силой ветра!";
    }
}
