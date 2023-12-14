package human;

import activity.*;
import room.*;

public class Neznayka extends Person implements Interactionable, Talkable {
    public Neznayka(String name) {
        super(name);
    }

    @Override
    public void toInteract(Person person, InterectingObject[] args) {
        System.out.print(person + " начал ");
        for (int i = 0; i < args.length; i++)
            if (i == args.length - 1)
                if (args[i] == InterectingObject.BUTTONS)
                    System.out.println(" нажимать на " + args[i].getDescription() + ".");
                else
                    System.out.println(" открывать " + args[i].getDescription() + ".");
            else
                if (args[i] == InterectingObject.BUTTONS)
                    System.out.print(" нажимать на " + args[i].getDescription() + ",");
                else
                    System.out.print(" открывать " + args[i].getDescription() + ",");
    }


    public void lie(Place place) {
        System.out.println(" растянулся " + place.getDescription() + ".");
    }

    public void put_under_head(HeadPad headPad) {
        System.out.println("Незнайка подложил под голову " + headPad.getDescription() + ".");
    }

    @Override
    public void say (String message) {
        if (message == "")
            message = "это";
        System.out.print("Сказав " + message + ", ");
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
        Neznayka neznayka = new Neznayka("Незнайка");
        return neznayka.getName();
    }
}
