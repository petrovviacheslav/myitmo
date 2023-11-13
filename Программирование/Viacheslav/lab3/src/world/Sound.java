package world;
import actions.*;

import java.util.ArrayList;
import java.util.Arrays;

public class Sound extends Character {
    private ArrayList<String> descriptionList = new ArrayList<>();
    public Sound(String name) {
        super(name);
    }

    public void setDescription(String... description){
        descriptionList.addAll(Arrays.asList(description));
    }

    public String getDescription(){
        String listDescr = "";
        for (int i = 0; i < descriptionList.size(); i++){
            if (i == descriptionList.size() - 1){
                listDescr += descriptionList.get(i) + " ";
            } else {
                listDescr += descriptionList.get(i) + ", ";
            }
        }
        return listDescr;
    }

    @Override
    public void say(Speech type, String message, Character toCharacter, SeverityLevel level) {
        System.out.print(this.getName());
        switch (level) {
            case Seriously:
                System.out.print(" серьёзно");
                break;
            default:
                break;
        }
        switch (type) {
            case Ask:
                System.out.print(" спросили у ");
                break;
            case Tell:
                System.out.print(" говорили ");
                break;
            default:
                break;
        }
        System.out.println(toCharacter + "у \"" + message + "\"");
    }
    @Override
    public void say() {
        System.out.println(this.getName() + " ничего не говорили");
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