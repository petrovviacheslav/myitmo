package human;

import activity.Listenable;
import activity.Standable;
import room.Adjective;
import room.Place;

public class Donut extends Person implements Listenable, Standable {
    public Donut(String name) {
        super(name);
    }


    public void follow(){
        System.out.println("Пончик последовал его примеру.");
    }

    public void getComfortably(Place where, Person who, Adjective adjective){
        System.out.println(who.getName() + " устроился поудобнее на " + adjective.getDescription() + " " + where.getDescription() + ".");
    }

    public void start_think_about_your_situation(Person who) {
        System.out.println(who + " начал обдумывать своё положение.");
    }

    public void admit_cowardice(Person who, Person whom, boolean flag) {
        if (!flag)
            System.out.println(who + " решил уже признаться в своей трусости, но подумал нада тем, как " + whom + " будет над ним смеяться и упрекать в трусости.");
        else
            System.out.println("Наконец " + who + " набрался храбрости настолько, что решил признаться персонажу " + whom + " в собственной трусости.");
    }

    public void check_sleep_status(Person whom){
        if (whom.getCondition() != Condition.AWAKE)
            System.out.println(getName() + " убедился, что " + whom + " " + whom.getSleepPower() + " " + whom.getCondition().getDescription() + ".");
    }

    public void go_out(Person whom){
        System.out.println(stand_up() + " и, стараясь не наступать персонажу " + whom + " на руки, прокрался к двери.");
    }

    @Override
    public String stand_up(){
        return getName() + " встал";
    }

    @Override
    public void toListen(Person whom){
        System.out.println(getName()+ " услышал как " + whom + " " + whom.getCharacterSound() + ".");
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
    public String toString(){
        Donut donut = new Donut("Пончик");
        return donut.getName();
    }
}
