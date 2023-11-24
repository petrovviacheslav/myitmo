package world;

import actions.*;

import java.util.ArrayList;
import java.util.Arrays;

public class Sound extends Character {
    private ArrayList<String> descriptionList = new ArrayList<>();

    public Sound(String name) {
        super(name);
    }

    public void setDescription(String... description) {
        descriptionList.addAll(Arrays.asList(description));
    }

    public String getDescription() {
        String listDescr = "";
        for (int i = 0; i < descriptionList.size(); i++) {
            if (i == descriptionList.size() - 1) {
                listDescr += descriptionList.get(i) + " ";
            } else {
                listDescr += descriptionList.get(i) + ", ";
            }
        }
        return listDescr;
    }

    @Override
    public void say(Speech type, String message, Character toCharacter, SeverityLevel level) {
        System.out.print(this.getName() + level.getLevel() + type.getType() + "и " + toCharacter + type.getCase() + " \"" + message + "\"");
    }

    @Override
    public void say(Speech type, String message, SeverityLevel level) {
        System.out.print(this.getName() + level.getLevel() + type.getType() + " \"" + message + "\"");
    }

    @Override
    public void noSay() {
        if (Math.random() < 0.5)
            System.out.println(this.getName() + " ничего не говорят");
        else
            System.out.println(this.getName() + " молчат");
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
        return "звук " + this.getName();
    }
}