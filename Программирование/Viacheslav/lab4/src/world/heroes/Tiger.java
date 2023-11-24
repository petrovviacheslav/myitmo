package world.heroes;

import world.heroes.Person;

public class Tiger extends Person {
    final Title title;
    public Tiger(String name) {
        super(name);
        title = new Title();
        title.setTitle("ужасно большой Выскочка");
    }

    private class Title{
        private String titleName;
        public void setTitle(String title){
            this.titleName = title;
        }
        public String getTitle(){
            return titleName;
        }
        @Override
        public String toString() {
            return getTitle();
        }
    }

    public void beWean(String rank){
        if(rank.isEmpty()) rank = title.toString();
        System.out.println(this.getName() + " надо отучить быть " + rank);
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
