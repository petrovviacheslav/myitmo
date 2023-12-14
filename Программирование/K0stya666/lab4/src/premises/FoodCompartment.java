package premises;

import activity.GoOut;
import human.Person;

public class FoodCompartment implements GoOut {
    public void goOut(Person person){
        System.out.println(person + " покинул пищевой отсек");
    }
}
