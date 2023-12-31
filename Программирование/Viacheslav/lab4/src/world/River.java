package world;

import actions.SeverityLevel;
import actions.Speech;
import world.heroes.Tiger;

import java.util.ArrayList;
import java.util.Arrays;

public class River extends Character {

    public River(String name) {
        super(name);
    }


    public class Condition{
        private ArrayList<String> conditionList = new ArrayList<>();
        public void setCondition(String... description) {
            conditionList.addAll(Arrays.asList(description));
        }
        public String getCondition() {
            String listDescr = River.this.getName() + " было ";
            for (int i = 0; i < conditionList.size(); i++) {
                if (i == conditionList.size() - 1) {
                    listDescr += conditionList.get(i) + " ";
                } else {
                    listDescr += conditionList.get(i) + ", ";
                }
            }
            return listDescr;
        }
        @Override
        public String toString() {
            return getCondition();
        }
    }




    @Override
    public void say(Speech type, String message, Character toCharacter, SeverityLevel level) {
        System.out.print(this.getName() + " "+ level.getLevel() + type.getType() + " " + toCharacter + type.getCase() + " \"" + message + "\"");
    }

    @Override
    public void say(Speech type, String message, SeverityLevel level) {
        System.out.print(this.getName() + level.getLevel() + type.getType() + " \"" + message + "\"");
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
        return "река " + this.getName();
    }
}