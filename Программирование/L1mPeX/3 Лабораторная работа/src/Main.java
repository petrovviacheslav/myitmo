//import Creatures.*;
//import InanimateCreatures.*;
//
//class Main {
//    public static void main(String[] args) {
//        Neznayka neznayka = new Neznayka("Незнайка");
//        Homemade homemade = new Homemade("Госпожа Минога");
//        Worker worker = new Worker("Сотрудник конторы");
//        Dog dog1 = new Dog("Бибик");
//        Dog dog2 = new Dog("Бобик");
//
//        Book book = new Book();
//        Company company = new Company();
//
//        neznayka.stroke(dog1);
//        neznayka.stroke(dog2);
//
//        worker.write("Незнайка, ул. Пушкина, д. Колотушкина, " + homemade.getName(), book);
//        homemade.getName();
//        worker.say("Незнайка, плати долг за фертинг!");
//        worker.setTax(neznayka, Services.BuyPromotions, 100);
//        if (!neznayka.canPay(100)) worker.say("Как только получишь жалование - приноси деньги");
//
//
//        neznayka.follow(dog1);
//        neznayka.follow(dog2);
//        neznayka.follow(homemade);
//        neznayka.goAway();
//    }
//}
class Main {

    public interface Animal {
        void makeSound();
    }

    public enum AnimalType implements Animal {
        CAT {
            @Override
            public void makeSound() {
                System.out.println("Мяу-мяу (поставьте)");
            }
        },
        DOG {
            @Override
            public void makeSound() {
                System.out.println("Гав-гав (пожалуйста)");
            }
        },
        BIRD {
            @Override
            public void makeSound() {
                System.out.println("Чирик-чирик (60 баллов)");
            }
        }
    }
    public static void main(String[] args) {
        AnimalType cat = AnimalType.CAT;
        cat.makeSound(); // выводит "Мяу"

        AnimalType dog = AnimalType.DOG;
        dog.makeSound(); // выводит "Гав"

        AnimalType bird = AnimalType.BIRD;
        bird.makeSound(); // выводит "Чирик-чирик"
    }
}