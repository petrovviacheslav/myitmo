package world;

public class Forest {
    private String name;
    private Character includedItem;
    public Forest(String name) {
        this.name = name;
    }
    public String getName() {
        return name == null ? "..." : name;
    }

    public void setIncludes(Character character) {
        includedItem = character;
    }

    public String getIncludes() {
        String item = this.getName() + " включает в себя";
        if (includedItem instanceof Sound){
            item += ((Sound) includedItem).getDescription() + " ";
        }
        item += includedItem.toString();
        return item;
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
        return "Новый лес: " + this.getName();
    }
}