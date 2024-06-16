package Moves;

import ru.ifmo.se.pokemon.*;

public class Mud_Slap extends StatusMove {
    public Mud_Slap() {
        super(Type.GROUND, 20, 100);
    }

    @Override
    public void applyOppEffects (Pokemon pokemon) {
        Effect eff = new Effect();
        eff.stat(Stat.ACCURACY, 0);
        eff.turns(2);

        pokemon.addEffect(eff);
    }

    @Override
    protected String describe() {
        return " использует Mud-Slap: наносит 20 урона, уменьшает точность соперника до 0";
    }
}