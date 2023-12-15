package premises;

import activity.GoOut;
import human.Person;

public class MainRoom implements GoOut {
    @Override
    public void goOut(Person person){
        System.out.println(person + " покинул главную комнату");
    }
}
