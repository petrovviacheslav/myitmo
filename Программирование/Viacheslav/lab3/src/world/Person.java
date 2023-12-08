package world;

import actions.*;

public class Person extends Character implements Perceptionable {
    public Person(String name) {
        super(name);
    }

    public void takePosition(String description) {
        System.out.println(this.getName() + " занял " + description + " позицию");
    }

    @Override
    public void listen(Person person, Boolean isListen) {
        if (isListen) {
            System.out.println(this.getName() + " слушал " + person);
        } else {
            System.out.println(this.getName() + " не слушал " + person);
        }
    }

    @Override
    public void openEyes(){
        System.out.println(this.getName() + " открывал глаза");
    }

    @Override
    public void closeEyes(){
        System.out.println(this.getName() + " закрывал глаза");
    }

    public void sit(String place) {
        System.out.println(this.getName() + " сидел " + place);
    }

    @Override
    public void say(Speech type, String message, Character toCharacter, SeverityLevel level) {
        System.out.print(this.getName() + level.getLevel());
        switch (type) {
            case Ask:
                System.out.println(" спросил у " + toCharacter + " \"" + message + "\"");
                break;
            case Tell:
                System.out.println(" говорил " + toCharacter + "у \"" + message + "\"");
                break;
            default:
                break;
        }
    }


    @Override
    public void say() {
        System.out.println(this.getName() + " ничего не говорил");
    }

    public void nod(SeverityLevel level){
        System.out.print(this.getName());
        if (level == SeverityLevel.Seriously){System.out.print(" серьёзно " );}
        System.out.println("кивал в ответ");
    }

    public void understand(UnderstandingLevel level){
        System.out.print(this.getName() + " показывает, что он");
        switch (level) {
            case All:
                System.out.print(" все-все ");
                break;
            case Nothing:
                System.out.print(" ничего не " );
                break;
            default:
                break;
        }
        System.out.println("понимает");
    }
    @Override
    public void look(Character character) {
        System.out.println(this.getName() + " смотрел на " + character);

    }

    @Override
    public int hashCode() {
        return super.hashCode() + this.getName().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj.hashCode() == this.hashCode();
    }

    @Override
    public String toString() {
        return "персонаж " + this.getName();
    }
}