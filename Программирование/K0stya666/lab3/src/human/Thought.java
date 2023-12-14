package human;

public class Thought {
    private static String AboutWhat;
    public Thought(String AboutWhat) {
        this.AboutWhat = AboutWhat;
    }
    public void mature(Person who) {
        System.out.println("У персонажа пончик появилась мысль: " + AboutWhat);
    }
}
