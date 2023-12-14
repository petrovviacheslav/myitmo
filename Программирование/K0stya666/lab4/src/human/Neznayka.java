package human;

import FunctionalInterfaces.WakeUpFunction;
import world.*;
import exceptions.*;

public class Neznayka extends Person implements WakeUpFunction {

    public class Fist {
        private String fist;
        public Fist(String fist){this.fist = fist;}
        public void PutYourFistIn(Person person){
            System.out.println(person + " подложил под голову " + fist);
        }
    }
    public Neznayka(String name) {
        super(name);
    }

    public void describeToInteract(){
        class InteractionItem {
            private InterectingObject interactionItem;

            public InteractionItem(InterectingObject interactionItem) {
                this.interactionItem = interactionItem;
            }

            public void toInteract() {
                System.out.println(toString() + " провзаимодействовал с предметами " + interactionItem.getDescription());
            }

            @Override
            public String toString(){
                Neznayka neznayka = new Neznayka("Незнайка");
                return neznayka.getName();
            }
        }
        InteractionItem buttons = new InteractionItem(InterectingObject.BUTTONS);
        InteractionItem thermostats = new InteractionItem(InterectingObject.THERMOSTAT);
        InteractionItem fridges = new InteractionItem(InterectingObject.FRIDGE);
        InteractionItem closets = new InteractionItem(InterectingObject.CLOSETS);

        buttons.toInteract();
        thermostats.toInteract();
        fridges.toInteract();
        closets.toInteract();
    }

    public void PutUnderHead(HeadPad headPad) {
        System.out.println("Незнайка подложил под голову " + headPad.getDescription() + ".");
    }

    @Override
    public void setLocation(Location location){
        super.setLocation(location);
        switch (location){
            case COMPARTMENT_BOTTOM -> System.out.println(toString() + " " + location.getDescription());
            default -> throw new UnknownLocationException("Нет такой локации: " + location);
        }
    }

    @Override
    public void WakeUp() {
        System.out.println(toString() + " проснулся");
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
