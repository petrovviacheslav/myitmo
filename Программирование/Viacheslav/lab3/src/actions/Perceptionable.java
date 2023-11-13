package actions;

import world.Character;
import world.Person;

public interface Perceptionable {
    public void listen(Person person, Boolean isListen);
    public void look(Character character);
    public void openEyes();
    public void closeEyes();

}
