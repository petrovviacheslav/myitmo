package Moves;

import ru.ifmo.se.pokemon.*;

public class Swagger extends StatusMove {
    public Swagger() {
        super(Type.NORMAL, 0, 85);
    }

    @Override
    protected void applySelfEffects (Pokemon pokemon) {
        pokemon.setMod(Stat.ATTACK, +2);
    }

    @Override
    public void applyOppEffects (Pokemon pokemon) {
        Effect eff = new Effect();
        eff.paralyze(pokemon);
    }
    
    @Override
    protected String describe() {
        return " использует атаку Swagger: парализует врага, увеличивает свою атаку на 2 единцы";
    }
}