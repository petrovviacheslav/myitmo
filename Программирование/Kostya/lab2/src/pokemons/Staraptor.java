package lab2.pokemons;
import ru.ifmo.se.pokemon.*;
import lab2.attacks.SpecialMove.Blizzard;
import lab2.attacks.StatusMove.ThunderWave;

public class Staraptor extends Pokemon{
    public Staraptor (String name, int level) {
        super (name, level);
        setStats (85, 120, 70, 50, 60, 100);
        setType (Type.NORMAL, Type.FLYING);
        setMove (new Blizzard(),
                new ThunderWave());
    }
}