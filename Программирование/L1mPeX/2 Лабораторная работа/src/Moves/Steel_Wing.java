package Moves;

import ru.ifmo.se.pokemon.*;

public class Steel_Wing extends StatusMove {
    public Steel_Wing() {
        super(Type.STEEL, 70, 90);
    }

    @Override
    protected void applySelfEffects (Pokemon pokemon) {
        pokemon.setMod(Stat.DEFENSE, +40);
    }

    @Override
    protected String describe() {
        return " использует атаку Steel Wing: наносит 70 урона, увеличивает себе защиту до 40 на 1 ход";
    }
}