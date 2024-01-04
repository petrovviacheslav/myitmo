package InanimateCreatures;

import Exceptions.ItemNotFound;
import Exceptions.ShelveOutOfSpace;
import Exceptions.ShleveNotFound;

import java.util.ArrayList;
import static java.lang.String.format;

public class Room {
    public class Walls {
        ArrayList<Object> items;
        public Walls() {
            this.items = new ArrayList<Object> ();
        }

        public void putItem(physicalItem obj) {
            obj.beHanged(Room.this);
            this.items.add(obj);
        }

        public void removeItem(Object obj) {
            
        }

        public ArrayList<Object> getItems() {
            return this.items;
        }
    }

    public class Baththub {
        Object whoIsIn;

        public Baththub() {
            this.whoIsIn = null;
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

    }

    public class Wardrobe {
        ArrayList< Object > shelve1;
        ArrayList < Object > shelve2;
        ArrayList < Object > shelve3;
        ArrayList < Object > shelve4;

        class Mirror {
            public Object showRetrospective(Object obj) {
                return obj;
            }
        }

        Mirror mirror;

        public Wardrobe() {
            this.shelve1 = new ArrayList < Object > ();
            this.shelve2 = new ArrayList < Object > ();
            this.shelve3 = new ArrayList < Object > ();
            this.shelve4 = new ArrayList < Object > ();
            this.mirror = new Mirror();
        }

        public Object retrieveSpecificItem(int indexOfShelve, Object obj) throws ItemNotFound, ShleveNotFound {
            if (indexOfShelve > 5 || indexOfShelve < 1) throw new ShleveNotFound(format("Данной полки %d нет в шкафу %s", indexOfShelve, this));
            switch (indexOfShelve) {
                case 1:
                    for (Object objTemp: this.shelve1) {
                        if (obj.equals(objTemp)) {
                            this.shelve1.remove(obj);
                            return objTemp;
                        }
                    }
                case 2:
                    for (Object objTemp: this.shelve2) {
                        if (obj.equals(objTemp)) {
                            this.shelve2.remove(obj);
                            return objTemp;
                        }
                    }
                case 3:
                    for (Object objTemp: this.shelve3) {
                        if (obj.equals(objTemp)) {
                            this.shelve3.remove(obj);
                            return objTemp;
                        }
                    }
                case 4:
                    for (Object objTemp: this.shelve4) {
                        if (obj.equals(objTemp)) {
                            this.shelve4.remove(obj);
                            return objTemp;
                        }
                    }
                default:
                    throw new ItemNotFound(format("На данной полке %d нет предмета %s. Шкаф %s", indexOfShelve, obj, this));
            }
        }

        public Object getSpecificItem(int indexOfShelve, Object obj) throws ItemNotFound, ShleveNotFound {
            if (indexOfShelve > 5 || indexOfShelve < 1) throw new ShleveNotFound(format("Данной полки %d нет в шкафу %s", indexOfShelve, this));
            switch (indexOfShelve) {
                case 1:
                    for (Object objTemp: this.shelve1) {
                        if (obj.equals(objTemp)) {
                            return objTemp;
                        }
                    }
                case 2:
                    for (Object objTemp: this.shelve2) {
                        if (obj.equals(objTemp)) {
                            return objTemp;
                        }
                    }
                case 3:
                    for (Object objTemp: this.shelve3) {
                        if (obj.equals(objTemp)) {
                            return objTemp;
                        }
                    }
                case 4:
                    for (Object objTemp: this.shelve4) {
                        if (obj.equals(objTemp)) {
                            return objTemp;
                        }
                    }
                default:
                    throw new ItemNotFound(format("На данной полке %d нет предмета %s. Шкаф %s", indexOfShelve, obj, this));
            }
        }

        public ArrayList<Object> getListOfItems(int indexOfShelve) throws ShleveNotFound {
            switch (indexOfShelve) {
                case 1:
                    return this.shelve1;
                case 2:
                    return this.shelve2;
                case 3:
                    return this.shelve3;
                case 4:
                    return this.shelve4;
                default:
                    throw new ShleveNotFound(format("Данной полки %d нет в шкафу %s", indexOfShelve, this));
            }
        }

        public void putItem(int indexOfShelve, Object obj) throws ShelveOutOfSpace, ShleveNotFound {
            if (indexOfShelve > 5 || indexOfShelve < 1) throw new ShleveNotFound(format("Данной полки %d нет в шкафу %s", indexOfShelve, this));
            switch (indexOfShelve) {
                case 1:
                    if (this.shelve1.size() >= 5)
                        throw new ShelveOutOfSpace("Место на полке 1 кончилось");
                    else {
                        this.shelve1.add(obj);
                        return;
                    }
                case 2:
                    if (this.shelve2.size() >= 5)
                        throw new ShelveOutOfSpace("Место на полке 2 кончилось");
                    else {
                        this.shelve2.add(obj);
                        return;
                    }
                case 3:
                    if (this.shelve3.size() >= 5)
                        throw new ShelveOutOfSpace("Место на полке 3 кончилось");
                    else {
                        this.shelve3.add(obj);
                        return;
                    }
                case 4:
                    if (this.shelve4.size() >= 5)
                        throw new ShelveOutOfSpace("Место на полке 4 кончилось");
                    else {
                        this.shelve4.add(obj);
                        return;
                    }
                default:
                    throw new ShleveNotFound(format("Данной полки %d нет в шкафу %s", indexOfShelve, obj));
            }
        }

    }
}
