package human;

import FunctionalInterfaces.TakeoffFunction;
import activity.*;
import world.*;

public class Donut extends Person implements Listenable, Standable, Thinkable, Breatheable {
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

    public void ClimbTheStairs(){
        System.out.println(toString() + " поднялся по лестнице.");
    }

    public void leave(Location location){
        System.out.println(toString() + " покинул место " + location.getDescription());
    }

    public void walk (Location where){
        System.out.println(toString() + " принялся бродить по месту " + where.getDescription());
    }

    public void FindLocation (Location what, boolean found){
        if (found){
            System.out.println(toString() + " нашёл " + what.getDescription());
        } else {
            System.out.println(toString() + " старался найти " + what.getDescription());
        }
    }

    public void goAround (Location what, String why) {
        System.out.println(toString() + " был " + why + ", поэтому несколько раз обошёл " + what.getDescription() + ".");
    }

    public void fear(String AboutWhat) {
        System.out.println(toString() + " опасался, что " + AboutWhat);
    }

    public void panic(){
        setCondition(Condition.PANIC);
        System.out.println(toString() + " поддался состоянию " + getCondition().getDescription());
    }

    public void PressButton(String WhatHappened){
        System.out.println(toString() + " нажал на предмет " + InterectingObject.BUTTONS.getDescription() + " и " + WhatHappened + ".");
    }

    public void PressButton(TakeoffFunction takeoffFunction){
        System.out.println(toString() + " нажал на предмет " + InterectingObject.BUTTONS.getDescription() + " и " + takeoffFunction + ".");
    }

    public void find(String What){
        System.out.println(toString() + " принялся искать " + What + ".");
    }

    public void GoInto(String where){
        System.out.println(toString() + " зашёл в " + where + ".");
    }

    public void found(String what){
        System.out.println(toString() + " нашёл " + what + ".");
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
    public void Think(String about) {
        System.out.println(toString() + " подумал: " + about + ".");
    }

    @Override
    public void breath(boolean isBreathing){
        if (!isBreathing)
            System.out.println(toString() + " затаил дыхание.");
        else
            System.out.println(toString() + " задышал полной грудью.");
    }

    public void toInteract(InterectingObject[] what, Location where){
        if (where!=Location.NOWHERE)
            for (int i = 0; i < what.length; i++) {
                System.out.println(toString() + " провзаимодействовал с предметом типа " + what[i].getDescription() + ", находящийся у предмета " + where.getDescription() + " в следствии чего, предмет " + where.getDescription() + " отворился.");
            }
        else {
            for (int i = 0; i < what.length; i++) {
                System.out.println(toString() + " провзаимодействовал с предметом типа " + what[i].getDescription() + ".");
            }
        }
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
