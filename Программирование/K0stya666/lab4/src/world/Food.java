package world;

import exceptions.InvalidMoodException;
import human.Person;

import java.util.Objects;

public class Food {
    private String name;

    public Food(String name) {
        this.name = name;
    }



    public static void toDelight(Person who) throws InvalidMoodException {
        if (Objects.equals(who.getMood(), "расстроен")) {
            System.out.println(who + " был настолько " + who.getMood() + ", что даже еда его не радовала.");
        }else {
            throw new InvalidMoodException(who + " НЕИЗВЕСТНОЕ НАСТРОЕНИЕ");
        }
    }

    @Override
    public String toString(){
        return name;
    }
}