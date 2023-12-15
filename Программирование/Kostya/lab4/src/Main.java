//variant 2702,5

import activity.GoOut;
import exceptions.*;
import human.*;
import places.Shelf;
import premises.*;
import world.*;

public class Main{
    public static void main(String[] args) {
        Neznayka neznayka = new Neznayka("Незнайка");
        Donut donut = new Donut("Пончик");
        Food food = new Food("самые разнообразные продукты");
        GoOut mainRoom = new MainRoom();
        GoOut cockpit = new Rocket.Cockpit();
        GoOut foodCompartment = new FoodCompartment();
        Neznayka.Fist fist = neznayka.new Fist("левый кулак");

        neznayka.describeToInteract();
        Shelf.stored(food);
        donut.setMood("расстроенК");

        try {
            Food.toDelight(donut);
        } catch (InvalidMoodException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            neznayka.setLocation(Location.COMPARTMENT_BOTTOM);
        }catch (UnknownLocationException e){
            System.out.println("Ошибка: " + e.getMessage());
        }

        fist.PutYourFistIn(neznayka);
        //neznayka.PutUnderHead(HeadPad.FIST);
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
        mainRoom.goOut(donut);

        //Part 2
        donut.Think("Вылезу из ракеты и убегу домой, вот тебе и весь сказ," +
                " а Незнайка пусть летит себе на Луну, если ему так хочется");
        donut.breath(false);
        donut.ClimbTheStairs();
        donut.toInteract(new InterectingObject[]{InterectingObject.BUTTONS}, Location.DOOR);

        foodCompartment.goOut(donut);
        donut.walk(Location.CROOKED_CORRIDOR);
        donut.FindLocation(Location.ELEVATOR, false);

        donut.setRocketKnowledge("не знаком c ракетным устройством");
        donut.goAround(Location.CROOKED_CORRIDOR, donut.getRocketKnowledge());
        donut.fear(neznayka.getName() + " проснётся и обнаружит его исчезновение.");
        donut.panic();
        donut.FindLocation(Location.ELEVATOR, true);
        Rocket.Cockpit.setPassenger(donut);
        donut.PressButton("поднялся вверх");

        cockpit.goOut(donut);
        donut.find("дверь шлюзовой камеры, через которую можно было выйти наружу");
        donut.GoInto("кнопочную кабину");
        donut.find("выключатель в темноте");
        donut.found("кнопку на неболььшом столике");
        donut.Think(InterectingObject.BUTTONS.getDescription() + " включает свет");
        donut.PressButton(" сразу подскочил кверху, оказавшись в состоянии невесомости");




    }
}