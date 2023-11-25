package world.heroes;

import actions.*;
import error.NothingSayException;
import world.Character;

public class Person extends Character implements Perceptionable, Lookable, Loving {
    public Person(String name) {
        super(name);
    }



    @Override
    public void listen(Person person, Boolean isListen) {
        if (isListen) {
            System.out.println(this.getName() + " слушал " + person);
        } else {
            System.out.println(this.getName() + " не слушал " + person);
        }
    }

    @Override
    public void openEyes() {
        System.out.println(this.getName() + " открывал глаза");
    }

    @Override
    public void closeEyes() {
        System.out.println(this.getName() + " закрывал глаза");
    }

    public void sit(String place) {
        System.out.println(this.getName() + " сидел " + place);
    }

    @Override
    public void say(Speech type, String message, Character toCharacter, SeverityLevel level) throws NothingSayException {
        if (message.isEmpty())
            throw new NothingSayException(this, " не может говорить пустую строку");
        else System.out.println(this.getName() + level.getLevel() + type.getType() + " " + toCharacter + type.getCase() + " \"" + message + "\"");
    }

    @Override
    public void say(Speech type, String message, SeverityLevel level) throws NothingSayException {
        if (message.isEmpty())
            throw new NothingSayException(this, " не может говорить пустую строку");
        else System.out.println(this.getName() + level.getLevel() + type.getType() + " \"" + message + "\"");
    }



    @Override
    public void look(Character character) {
        System.out.println(this.getName() + " смотрел на " + character);

    }

    @Override
    public void love(Person person) {
        System.out.println(this.getName() + " любит " + person);

    }

    @Override
    public int hashCode() {
        return super.hashCode() + this.getName().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj.hashCode() == this.hashCode();
    }

    @Override
    public String toString() {
        return "персонаж " + this.getName();
    }
}