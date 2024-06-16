
import actions.*;
import world.*;

public class Main {
    public static void main(String[] args) {
        Person rabbit = new Person("Кролик");
        Person vinni = new Person("Винни-Пух");
        Person piglet = new Person("Пятачок");

        River river = new River("Река");
        Forest forest = new Forest("Лес");


        rabbit.look(river);
        piglet.look(river);
        rabbit.say();
        piglet.say();

        river.say();
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

    }



}
