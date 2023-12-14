package room;

import human.Person;

import java.util.Objects;

public class Food {
    private String name;

    public Food(String name) {
        this.name = name;
    }

    public void stored(Place where) {
        System.out.println(where.getDescription() + " хранились самые разнообразные продукты.");
    }

    public static void toDelight(Person who) {
        if (Objects.equals(who.getMood(), "расстроен")) {
            System.out.println(who + " был настолько " + who.getMood() + ", что даже еда его не радовала.");
        } else
            System.out.println(who + " был настолько " + who.getMood() + ", что даже еда его радовала.");
    }

    @Override
    public String toString(){
        return name;
    }
}