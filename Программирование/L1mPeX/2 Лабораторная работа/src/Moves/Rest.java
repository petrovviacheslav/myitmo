package Moves;

import ru.ifmo.se.pokemon.*;

public class Rest extends StatusMove {
    public Rest() {
        super(Type.PSYCHIC, 0, 0);
    }

    @Override
    protected void applySelfEffects (Pokemon pokemon) {
        Effect eff = new Effect();
        Effect eff1 = new Effect();
        eff.stat(Stat.HP, +100);
        eff1.sleep(pokemon);
        eff1.turns(2);

        pokemon.addEffect(eff);
        pokemon.addEffect(eff1);
    }

    @Override
    protected String describe() {
        return " использует Rest: засыпает на 2 хода и поднимает свое здоровье до 100";
    }
}