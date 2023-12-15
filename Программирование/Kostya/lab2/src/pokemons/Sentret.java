package lab2.pokemons;
import ru.ifmo.se.pokemon.*;
import lab2.attacks.PhysicalMove.Fly;
import lab2.attacks.PhysicalMove.Magnitude;
import lab2.attacks.SpecialMove.Aeroblast;
import lab2.attacks.StatusMove.SleepTalk;

public class Sentret extends Pokemon {
    public Sentret (String name, int level) {
        super (name, level);
        setStats(35, 46, 34, 35, 45, 20);
        setType (Type.NORMAL);
        setMove(new Fly(), 
                new Aeroblast(),
                new SleepTalk(), 
                new Magnitude());
        
    }
}
