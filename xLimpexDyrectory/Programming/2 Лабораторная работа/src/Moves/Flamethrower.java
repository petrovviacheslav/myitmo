package Moves;

import ru.ifmo.se.pokemon.*;

public class Flamethrower extends StatusMove {
    public Flamethrower() {
        super(Type.FIRE, 90, 100);
    }

    @Override
    public void applyOppEffects (Pokemon pokemon) {
        Effect.burn(pokemon);
    }

    @Override
    protected String describe() {
        return " использует Flamethrower: наносит 90 урона, поджигает противника";
    }
}