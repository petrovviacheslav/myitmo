//variant 2702

import human.SleepPower;
import human.Condition;
import human.Donut;
import human.Neznayka;
import human.Thought;
import room.*;

public class Main{
    public static void main(String[] args) {
        Neznayka neznayka = new Neznayka("Незнайка");
        Donut donut = new Donut("Пончик");
        Food food = new Food("самые разнообразные продукты");

        neznayka.toInteract(neznayka,new InterectingObject[]{InterectingObject.BUTTONS,InterectingObject.CLOSETS,InterectingObject.THERMOSTAT,InterectingObject.FRIDGE});
        food.stored(Place.SHELF);
        donut.setMood("расстроен");
        Food.toDelight(donut);
        neznayka.say(""); System.out.print(neznayka); neznayka.lie(Place.COMPARTMENT_BOTTOM);
        neznayka.put_under_head(HeadPad.FIST);
        donut.follow();
        donut.getComfortably(Place.PLASTIC, donut, Adjective.SOFT);
        donut.start_think_about_your_situation(donut);

        Thought thought = new Thought("я расхотел лететь");
        thought.mature(donut);
        donut.admit_cowardice(donut, neznayka, false);
        donut.admit_cowardice(donut, neznayka, true);

        neznayka.setCondition(Condition.SLEEPING, SleepPower.STRONG);
        donut.toListen(neznayka);
        donut.check_sleep_status(neznayka);
        donut.go_out(neznayka);

    }


}