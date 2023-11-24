package actions;

import world.heroes.Person;

public interface Perceptionable {
    public void listen(Person person, Boolean isListen);

    public void openEyes();
    public void closeEyes();

}
