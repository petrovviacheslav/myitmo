import Creatures.*;
import InanimateCreatures.*;

class Main {
    public static void main(String[] args) {
        Neznayka neznayka = new Neznayka("Незнайка");
        Homemade homemade = new Homemade("Госпожа Минога");
        Worker worker = new Worker("Сотрудник конторы");
        Dog dog1 = new Dog("Бибик");
        Dog dog2 = new Dog("Бобик");

        Book book = new Book();
        Company company = new Company();

        neznayka.stroke(dog1);
        neznayka.stroke(dog2);

        worker.write("Незнайка, ул. Пушкина, д. Колотушкина, " + homemade.getName(), book);
        homemade.getName();
        worker.say("Незнайка, плати долг за фертинг!");
        worker.setTax(neznayka, Services.BuyPromotions, 100);
        if (!neznayka.canPay(100)) worker.say("Как только получишь жалование - приноси деньги");


        neznayka.follow(dog1);
        neznayka.follow(dog2);
        neznayka.follow(homemade);
        neznayka.goAway();
    }
}