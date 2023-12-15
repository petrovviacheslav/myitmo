package lab2.attacks.StatusMove;
import ru.ifmo.se.pokemon.*;

public class SleepTalk extends StatusMove{
    public SleepTalk() {
        super(Type.NORMAL, 0, 0);
    }

    @Override
    protected String describe() {
        return "Покемон, находясь в глубоком сне, случайным образом произносит одну из своих атак, используя силу подсознания!";
    }
}
