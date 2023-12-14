package lab2.pokemons;
import ru.ifmo.se.pokemon.*;
import lab2.attacks.PhysicalMove.TripleKick;
import lab2.attacks.SpecialMove.Blizzard;
import lab2.attacks.StatusMove.FocusEnergy;
import lab2.attacks.StatusMove.ThunderWave;

public class Bibarel extends Pokemon {
    public Bibarel (String name, int level) {
        super (name, level);
        setStats (79, 85, 60, 55, 60, 71);
        setType (Type.NORMAL, Type.WATER);
        setMove (new Blizzard(),
                new ThunderWave(),
                new FocusEnergy(),
                new TripleKick());
    }
}
