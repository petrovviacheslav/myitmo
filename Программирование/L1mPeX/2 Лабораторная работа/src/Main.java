import Pokemons.*;
import Moves.*;
import ru.ifmo.se.pokemon.*;

public class Main {
    public static void main(String[] args) {
        Battle battle = new Battle();

        Pokemon Fearow_1 = new Fearow("Fearow_1", 1);
        Pokemon Fearow_2 = new Fearow("Fearow_2", 1);
        Pokemon Flygon_1 = new Flygon("Flygon_1", 1);
        Pokemon Flygon_2 = new Fearow("Flygon_2", 1);
        Pokemon Spearow_1 = new Flygon("Spearow_1", 1);
        Pokemon Spearow_2 = new Fearow("Spearow_2", 1);

        battle.addAlly(Fearow_1);
        battle.addAlly(Fearow_2);
        battle.addAlly(Spearow_1);
        battle.addFoe(Flygon_1);
        battle.addFoe(Flygon_2);
        battle.addFoe(Spearow_2);

        battle.go();
    }
}
