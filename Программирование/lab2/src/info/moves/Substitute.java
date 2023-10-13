package info.moves;

import ru.ifmo.se.pokemon.*;

public class Substitute extends StatusMove {
    public Substitute() {
        super(Type.NORMAL, 0, 0);
    }

    @Override
    public void applySelfEffects(Pokemon p) {
        // Использует HP для создания приманки, которая принимает удары.
    }

    @Override
    protected String describe() {
        return "использует Substitute";
    }
}
