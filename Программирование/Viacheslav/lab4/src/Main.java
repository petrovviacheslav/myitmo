
import actions.*;
import world.*;
import world.Character;
import world.heroes.*;

public class Main {

    public static void main(String[] args) {
        Rabbit rabbit = new Rabbit("Кролик");
        Vinni vinni = new Vinni("Винни-Пух");
        Piglet piglet = new Piglet("Пятачок");
        Tiger tigra = new Tiger("Тигра");

        River river = new River("Река");
        Forest forest = new Forest("Лес");

        // анонимный класс вроде как
        Lookable they = new Lookable() {
            @Override
            public void look(Character character) {
                System.out.print("Они смотрели на " + character);
            }
        };
        they.look(river);
        System.out.println(", ничего не говоря");


        river.noSay();
        river.setCondition("хорошо", "спокойно");
        System.out.println(river.getCondition());


        System.out.println();

        rabbit.sit("рядом с входной дверью");
        piglet.sit("рядом с входной дверью");
        vinni.sit("с ними");

        System.out.println();

        Sound sounds = new Sound("звуки");
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

        piglet.say(Speech.Tell, "Тигра действительно ужасно большой выскочка, и если придумать, как его укратить, это будет Очень хорошая мысль", SeverityLevel.NotSeriously);
        piglet.push(vinni);

        vinni.feel("его куда-то уносит");
        vinni.standUp();
        vinni.feel("неясные воспоминания пробудились из-за слова 'урок'");

        rabbit.ready("всё, что угодно");
        rabbit.say(Speech.Ask, "с какого места мне начать?", SeverityLevel.NotSeriously);
        vinni.say(Speech.Answer, "с того места, где мех попал мне в ухо", SeverityLevel.NotSeriously);
        rabbit.say(Speech.Ask, "когда это было?", SeverityLevel.NotSeriously);
        vinni.say(Speech.Answer, "я точно не знаю", SeverityLevel.NotSeriously);
        vinni.listen(rabbit, false);

        //tigra.beWean("задира");
        tigra.beWean("");
    }


}