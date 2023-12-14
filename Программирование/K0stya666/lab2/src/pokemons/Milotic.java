package lab2.pokemons;
import ru.ifmo.se.pokemon.*;
import lab2.attacks.PhysicalMove.Magnitude;
import lab2.attacks.SpecialMove.HydroPump;
import lab2.attacks.SpecialMove.Thunder;
import lab2.attacks.StatusMove.LightScreen;

public class Milotic extends Pokemon {
    public Milotic (String name, int level) {
        super (name, level);
        setStats (95, 60, 79, 100, 125, 81);
        setType (Type.WATER);
        setMove (new Magnitude(),
                new HydroPump(),
                new LightScreen(),
                new Thunder());
    }
}
