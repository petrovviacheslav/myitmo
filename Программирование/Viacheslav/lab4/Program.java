package actions;

public class Program{

    public static void main(String[] args) {

        Journal b1 = new Journal("урщошы");
        b1.print();
    }
}
interface Printable {

    default void print(){

        System.out.println("Undefined printable");
    }
}
class Journal implements Printable {

    private String name;

    String getName(){
        return name;
    }
    Journal(String name){

        this.name = name;
    }
}
