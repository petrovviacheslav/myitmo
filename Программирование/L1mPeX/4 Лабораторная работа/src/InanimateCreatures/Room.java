package InanimateCreatures;

import Exceptions.ItemNotFound;
import Exceptions.ShelveOutOfSpace;
import Exceptions.ShelveNotFound;

import InanimateCreatures.physicalItem;

import java.util.ArrayList;
import static java.lang.String.format;

public class Room {
    public class Walls {
        ArrayList<Object> items;
        public Walls() {
            this.items = new ArrayList<Object> ();
        }

        public void putItem(physicalItem obj) {
            obj.beHanged(Room.Walls.this);
            this.items.add(obj);
        }

        public void removeItem(physicalItem obj) {
            obj.beRemoved(Room.Walls.this);
            this.items.remove(obj);
        }

        public ArrayList<Object> getItems() {
            return this.items;
        }

        @Override
        public String toString() {
            return "Стена";
        }
    }

    public class Baththub {
        private Object whoIsIn;
        private String forWho;

        public Baththub(String name) {
            this.whoIsIn = null;
            this.forWho = name;
        }

        public void placeInto(Object obj) {
            this.whoIsIn = obj.toString();
            System.out.println(String.format("%s в ванной", obj));
        }

        public Object getWhoIsIn() {
            return this.whoIsIn;
        }

        public void retriveOut() throws ItemNotFound {
            if (whoIsIn == null) throw new ItemNotFound("Никого в ванной нет");
            else{
                System.out.println(String.format("%s больше не в ванной", whoIsIn));
                this.whoIsIn = null;
            }
        }

        public String getName() {
            return this.forWho;
        }
    }

    public class Bed {
        private Object whoIsIn;
        private String forWho;

        public Bed(String name) {
            this.whoIsIn = null;
            this.forWho = name;
        }

        public void placeInto(Object obj) {
            this.whoIsIn = obj.toString();
            System.out.println(String.format("%s в ванной", obj));
        }

        public Object getWhoIsIn() {
            return this.whoIsIn;
        }

        public void retriveOut() throws ItemNotFound {
            if (this.whoIsIn == null) throw new ItemNotFound("Никого в кровати нет");
            else{
                System.out.println(String.format("%s больше не в кровати", this.whoIsIn));
                this.whoIsIn = null;
            }
        }

        public String getName() {
            return this.forWho;
        }
    }

    public class Wardrobe {
        ArrayList< Object > shelve1;
        ArrayList < Object > shelve2;
        ArrayList < Object > shelve3;
        ArrayList < Object > shelve4;
        ArrayList[] wardrobe;

        public Object showRetrospective(Object obj) {
            class Mirror {
                public Object getImage(Object obj) {
                    return obj;
                }
            }
            Mirror mirror = new Mirror();

            return mirror.getImage(obj);
        }

        public Wardrobe() {
             this.shelve1 = new ArrayList < Object > ();
             this.shelve2 = new ArrayList < Object > ();
             this.shelve3 = new ArrayList < Object > ();
             this.shelve4 = new ArrayList < Object > ();
             this.wardrobe = new ArrayList[]{shelve1, shelve2, shelve3, shelve4};
        }

        public Object retrieveSpecificItem(int indexOfShelve, Object obj) throws ItemNotFound, ShelveNotFound {
            if (indexOfShelve > 5 || indexOfShelve < 1)
                throw new ShelveNotFound(format("Данной полки %d нет в шкафу %s", indexOfShelve, this));
            for (Object objTemp : wardrobe[indexOfShelve]) {
                if (obj.equals(objTemp)) {
                    this.wardrobe[indexOfShelve].remove(obj);
                    return objTemp;
                }
            }
            throw new ItemNotFound(format("На данной полке %d нет предмета %s. Шкаф %s", indexOfShelve, obj, this));
        }

        public Object getSpecificItem(int indexOfShelve, Object obj) throws ItemNotFound, ShelveNotFound {
            if (indexOfShelve > 5 || indexOfShelve < 1)
                throw new ShelveNotFound(format("Данной полки %d нет в шкафу %s", indexOfShelve, this));
            for (Object objTemp : wardrobe[indexOfShelve]) {
                if (obj.equals(objTemp)) {
                    return objTemp;
                }
            }
            throw new ItemNotFound(format("На данной полке %d нет предмета %s. Шкаф %s", indexOfShelve, obj, this));
        }

        public ArrayList getListOfItems(int indexOfShelve) throws ShelveNotFound {
            if (indexOfShelve > 5 || indexOfShelve < 1)
                throw new ShelveNotFound(format("Данной полки %d нет в шкафу %s", indexOfShelve, this));
            return this.wardrobe[indexOfShelve-1];
        }

        public void putItem(int indexOfShelve, Object obj) throws ShelveOutOfSpace, ShelveNotFound {
            if (indexOfShelve > 5 || indexOfShelve < 1) throw new ShelveNotFound(format("Данной полки %d нет в шкафу %s", indexOfShelve, this));
            switch (indexOfShelve) {
                case 1:
                    if (this.shelve1.size() >= 5)
                        throw new ShelveOutOfSpace("Место на полке 1 кончилось");
                    else {
                        this.shelve1.add(obj);
                        break;
                    }
                case 2:
                    if (this.shelve2.size() >= 5)
                        throw new ShelveOutOfSpace("Место на полке 2 кончилось");
                    else {
                        this.shelve2.add(obj);
                        break;
                    }
                case 3:
                    if (this.shelve3.size() >= 5)
                        throw new ShelveOutOfSpace("Место на полке 3 кончилось");
                    else {
                        this.shelve3.add(obj);
                        break;
                    }
                case 4:
                    if (this.shelve4.size() >= 5)
                        throw new ShelveOutOfSpace("Место на полке 4 кончилось");
                    else {
                        this.shelve4.add(obj);
                        break;
                    }
                default:
                    throw new ShelveNotFound(format("Данной полки %d нет в шкафу %s", indexOfShelve, obj));
            }
        }
    }
}
