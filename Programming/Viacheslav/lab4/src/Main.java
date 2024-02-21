
import actions.*;
import error.NameException;
import error.NothingSayException;
import world.*;
import world.heroes.*;

public class Main {

    public static void main(String[] args) {
        try {
            Rabbit rabbit = new Rabbit("Кролик");
            Vinni vinni = new Vinni("Винни-Пух");
            Piglet piglet = new Piglet("Пятачок");
            Tiger tigra = new Tiger("Тигра");

            River river = new River("Река");
            Forest forest = new Forest("Лес");




            // анонимный класс вроде как
            Lookable they = character -> System.out.print("Они смотрели на " + character);
            they.look(river);
            System.out.println(", ничего не говоря");

            River.Condition cond = river.new Condition();

            river.noSay();
            cond.setCondition("хорошо", "спокойно");
            System.out.println(cond.getCondition());



            System.out.println();

            rabbit.sit("рядом с входной дверью");
            piglet.sit("рядом с входной дверью");
            vinni.sit("с ними");

            System.out.println();

            Sound sounds = new Sound("звуки");
            sounds.descr.setDescription("тихие", "спокойные");
            forest.setIncludes(sounds);
            System.out.println(forest.getIncludes());
            sounds.say(Speech.Tell, "Не слушай Кролика. Слушай меня.", vinni, SeverityLevel.NotSeriously);

            System.out.println();

            vinni.takePosition("удобную");
            vinni.listen(rabbit, false);
            vinni.openEyes();
            vinni.say(Speech.Tell, "Ах!", rabbit, SeverityLevel.NotSeriously);
            vinni.closeEyes();
            vinni.say(Speech.Tell, "Верно, верно!", rabbit, SeverityLevel.NotSeriously);

            System.out.println();

            rabbit.say(Speech.Ask, "Ты понимаешь, что я имею в виду, Пятачок?", piglet, SeverityLevel.Seriously);
            piglet.nod(SeverityLevel.Seriously);
            piglet.understand(UnderstandingLevel.All);

            System.out.println();


            //tigra.beWean("задира");
            tigra.beWean("");
            piglet.say(Speech.Tell, "Тигра ужасно большой выскочка, и если придумать, как его укротить, это будет Очень Хорошая мысль", SeverityLevel.NotSeriously);

            System.out.println();

            piglet.push(vinni);
            vinni.feel("его куда-то уносит");
            vinni.standUp();

            System.out.println();

            vinni.feel("неясные воспоминания пробудились из-за слова 'урок'");

            System.out.println();

            rabbit.ready("всё, что угодно");
            rabbit.say(Speech.Ask, "с какого места мне начать?", SeverityLevel.NotSeriously);
            vinni.say(Speech.Answer, "с того места, где мех попал мне в ухо", SeverityLevel.NotSeriously);
            rabbit.say(Speech.Ask, "когда это было?", SeverityLevel.NotSeriously);
            vinni.say(Speech.Answer, "я точно не знаю", SeverityLevel.NotSeriously);
            vinni.listen(rabbit, false);

            System.out.println();

            piglet.settle();
            piglet.say(Speech.Tell, "Мы просто хотели придумать, как отучить Тигру. Нельзя отрицать, что он выскочка", SeverityLevel.NotSeriously);
            Loving we = new Loving() {
                @Override
                public void love(Person person) {
                    System.out.println("Мы любим " + person);
                }
            };
            we.love(tigra);



        }
        catch (NothingSayException | NameException e){
            System.out.println(e.getMessage());
        }


    }

    static {
        //локальный класс
        class Noon {
            public void description(String adjective1, String adjective2){
                System.out.println("Полдень был " + adjective1 + ", " + adjective2);
            }
        }

        Noon noon1 = new Noon();

        noon1.description("дремотный", "летний");
        System.out.println();
    }


}