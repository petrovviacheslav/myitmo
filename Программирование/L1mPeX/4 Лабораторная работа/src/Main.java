import Creatures.*;
import InanimateCreatures.*;
import Exceptions.*;

import java.io.IOException;
import java.time.LocalTime; // мяу
class Main {
    public static class Company { // Ну она просто есть, зачем тогда в отдельный файл выносить?
        public void provideServices(Neznayka forWho) {
            System.out.println("Комания оказывает улсуги для {1}".formatted(forWho.getName()));
        };
    }
    public static void main(String[] args) throws MethodNotAllowed, ShelveOutOfSpace, ItemNotFound, ShelveNotFound {
        Room bedroom = new Room();
        Room.Bed bed1 = bedroom.new Bed("Незнайка");
        Room.Bed bed2 = bedroom.new Bed("Роланд");
        Room.Bed bed3 = bedroom.new Bed("Мимишка");
        Room bathroom = new Room();
        Room.Baththub baththub1 = bathroom.new Baththub("Роланд");
        Room.Baththub baththub2 = bathroom.new Baththub("Мимишка");
        physicalItem picture1 = new physicalItem("Портрет Ролана");
        physicalItem picture2 = new physicalItem("Портрет Миноги");
        Room.Walls walls = bedroom.new Walls();
        walls.putItem(picture1);
        walls.putItem(picture2);
        Room.Wardrobe wardrobe = bedroom.new Wardrobe();
        physicalItem fufaika = new physicalItem("Фуфайка");
        physicalItem poponka = new physicalItem("Попонка");
        physicalItem jacket = new physicalItem("Желетка");
        physicalItem pijama = new physicalItem("Пижама");
        physicalItem pantaloni = new physicalItem("Панталоны");
        try {
            wardrobe.putItem(1, fufaika);
        } catch (ShelveOutOfSpace e) {
            throw new ShelveOutOfSpace("Место на данной полке закончилось");
        } catch (ShelveNotFound e) {
            throw new ShelveNotFound("Нет полки с таким индексом");
        }
        try {
            wardrobe.putItem(1, poponka);
        } catch (ShelveOutOfSpace e) {
            throw new ShelveOutOfSpace("Место на данной полке закончилось");
        } catch (ShelveNotFound e) {
            throw new ShelveNotFound("Нет полки с таким индексом");
        }

        try {
            wardrobe.putItem(1, jacket);
        } catch (ShelveOutOfSpace e) {
            throw new ShelveOutOfSpace("Место на данной полке закончилось");
        } catch (ShelveNotFound e) {
            throw new ShelveNotFound("Нет полки с таким индексом");
        }

        try {
            wardrobe.putItem(1, pijama);
        } catch (ShelveOutOfSpace e) {
            throw new ShelveOutOfSpace("Место на данной полке закончилось");
        } catch (ShelveNotFound e) {
            throw new ShelveNotFound("Нет полки с таким индексом");
        }

        try {
            wardrobe.putItem(1, pantaloni);
        } catch (ShelveOutOfSpace e) {
            throw new ShelveOutOfSpace("Место на данной полке закончилось");
        } catch (ShelveNotFound e) {
            throw new ShelveNotFound("Нет полки с таким индексом");
        }


        physicalItem book = new physicalItem("Книга");
        Company company = new Main.Company();
        Neznayka neznayka = new Neznayka("Незнайка");
        Homemade homemade = new Homemade("Госпожа Минога");
        Worker worker = new Worker("Сотрудник конторы");
        Dog dog1 = new Dog("Роланд");
        Dog dog2 = new Dog("Мими");

        homemade.putDown(dog1);
        dog1.followBy(neznayka);
        dog1.sit();
        neznayka.stroke(dog1);
        neznayka.stroke(dog2);

        worker.write("Незнайка, ул. Пушкина, д. Колотушкина, " + homemade.getName(), book);
        homemade.getName();
        worker.say("Незнайка, плати долг за фертинг!");
        worker.setTax(neznayka, Services.BuyPromotions, 100);
        if (!neznayka.canPay(100)) {
            worker.say("Как только получишь жалование - приноси деньги");
        }

        neznayka.followBy(dog1);
        neznayka.followBy(dog2);
        neznayka.followBy(homemade);
        neznayka.goAway();

        System.out.println(String.format("На стене: %s", walls.getItems()));
        System.out.println(String.format("Кровать для %s", bed1.getName()));
        System.out.println(String.format("Кровать для %s", bed2.getName()));
        System.out.println(String.format("Кровать для %s", bed3.getName()));

        System.out.println(String.format("В шкафу есть: %s", wardrobe.getListOfItems(1)));

        System.out.println(String.format("Ванна для %s", baththub1.getName()));
        System.out.println(String.format("Ванна для %s", baththub2.getName()));

        LocalTime currentTime = LocalTime.now();
        if (currentTime.isBefore(LocalTime.NOON)) {
            homemade.wash(dog2);
            currentTime.plusMinutes(10);

            homemade.wash(dog1);
            homemade.stroke(dog1);
            currentTime.plusMinutes(50);
        }
        else if (currentTime.isBefore(LocalTime.of(18, 0))) {
            homemade.wash(dog2);
            currentTime.plusMinutes(10);
        }
        else {
            homemade.wash(dog2);
            currentTime.plusMinutes(10);
        }

        try {
            dog1.say("asd");
        }
        catch (MethodNotAllowed e) {
            System.out.println();
            System.out.println(e.getCauseOfException());
            System.out.println();
            System.out.println(e.getCause());
            
        }
    }
}