package places;

import world.Food;

public class Shelf {
    private static Food storedObject;



    public static void stored(Food food)  {
        Shelf.storedObject = food;
        System.out.println("На полках хранились " + food.toString());

    }

    public Food getStoredObject() {
        return storedObject;
    }
}
