import Creatures.*;
import InanimateCreatures.*;
import Exceptions.*;

import java.lang.reflect.Method;

class Main {
    public static void main(String[] args) throws MethodNotAllowed, ShelveOutOfSpace, ItemNotFound, ShleveNotFound {
        Room bedroom = new Room();
        Room.Walls walls = bedroom.new Walls();
        Room.Wardrobe wardrobe = bedroom.new Wardrobe();
        Room bathroom = new Room();
        Room.Baththub baththub = bathroom.new Baththub();

        // Заполняем стены в комнате
        physicalItem fufaika = new physicalItem("фуфайка");
        fufaika.beHanged(bedroom);

        Book book = new Book();
        Company company = new Company();
        Neznayka neznayka = new Neznayka("Незнайка");
        Homemade homemade = new Homemade("Госпожа Минога");
        Worker worker = new Worker("Сотрудник конторы");
        Dog dog1 = new Dog("Бибик");
        Dog dog2 = new Dog("Бобик");

        homemade.putDown(dog1);
        dog1.followBy(neznayka);
        dog1.sit();
        neznayka.stroke(dog1);
        neznayka.stroke(dog2);

        worker.write("Незнайка, ул. Пушкина, д. Колотушкина, " + homemade.getName(), book);
        homemade.getName();
        worker.say("Незнайка, плати долг за фертинг!");
        worker.setTax(neznayka, Services.BuyPromotions, 100);
        if (!neznayka.canPay(100)) worker.say("Как только получишь жалование - приноси деньги");


        neznayka.followBy(dog1);
        neznayka.followBy(dog2);
        neznayka.followBy(homemade);
        neznayka.goAway();
    }
}