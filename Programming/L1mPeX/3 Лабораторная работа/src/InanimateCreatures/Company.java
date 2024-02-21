package InanimateCreatures;

import Creatures.Neznayka;

public class Company {
    public void provideServices(Neznayka forWho) {
        System.out.println("Комания оказывает улсуги для {1}".formatted(forWho.getName()));
    }
}
