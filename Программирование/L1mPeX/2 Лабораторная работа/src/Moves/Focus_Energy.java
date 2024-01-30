package Moves;

import ru.ifmo.se.pokemon.*;

public class Focus_Energy extends StatusMove {
    public Focus_Energy() {
        super(Type.NORMAL, 0, 100);
    }

    @Override
    protected void applySelfEffects (Pokemon pokemon) {
        Effect eff = new Effect();
        eff.stat(Stat.ATTACK, +50);
        eff.turns(1);
        pokemon.addEffect(eff);
    }

    @Override
    protected String describe() {
        return " использует атаку Focus Energy: повышает себе атаку на 50 на 1 ход";
    }
}