package InanimateCreatures;

import Exceptions.ItemNotFound;
import Exceptions.ShelveOutOfSpace;
import Exceptions.ShleveNotFound;
import java.util.ArrayList;

/* loaded from: Room.class */
public class Room {

    /* loaded from: Room$Walls.class */
    public class Walls {
        ArrayList<Object> items = new ArrayList<>();

        public Walls() {
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

    /* loaded from: Room$Baththub.class */
    public class Baththub {
        Object whoIsIn = null;

        public Baththub(Room this$0) {
        }

        public void placeInto(Object obj) {
            this.whoIsIn = obj.toString();
            System.out.println(String.format("%s в ванной", obj));
        }

        public Object getWhoIsIn() {
            return this.whoIsIn;
        }

        public void retriveOut() throws ItemNotFound {
            if (this.whoIsIn == null) {
                throw new ItemNotFound("Никого в ванной нет");
            }
            System.out.println(String.format("%s больше не в ванной", this.whoIsIn));
            this.whoIsIn = null;
        }
    }

    /* loaded from: Room$Wardrobe.class */
    public class Wardrobe {
        ArrayList<Object> shelve1 = new ArrayList<>();
        ArrayList<Object> shelve2 = new ArrayList<>();
        ArrayList<Object> shelve3 = new ArrayList<>();
        ArrayList<Object> shelve4 = new ArrayList<>();
        Mirror mirror = new Mirror(this);

        /* loaded from: Room$Wardrobe$Mirror.class */
        class Mirror {
            Mirror(Wardrobe this$1) {
            }

            public Object showRetrospective(Object obj) {
                return obj;
            }
        }

        public Wardrobe(Room this$0) {
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x0086  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00b7  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x00e8  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.Object retrieveSpecificItem(int r9, java.lang.Object r10) throws Exceptions.ItemNotFound, Exceptions.ShleveNotFound {
            /*
                Method dump skipped, instructions count: 296
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: InanimateCreatures.Room.Wardrobe.retrieveSpecificItem(int, java.lang.Object):java.lang.Object");
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x007d  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00a5  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x00cd  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.Object getSpecificItem(int r9, java.lang.Object r10) throws Exceptions.ItemNotFound, Exceptions.ShleveNotFound {
            /*
                Method dump skipped, instructions count: 260
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: InanimateCreatures.Room.Wardrobe.getSpecificItem(int, java.lang.Object):java.lang.Object");
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
                    throw new ShleveNotFound(String.format("Данной полки %d нет в шкафу %s", Integer.valueOf(indexOfShelve), this));
            }
        }

        public void putItem(int indexOfShelve, Object obj) throws ShelveOutOfSpace, ShleveNotFound {
            if (indexOfShelve > 5 || indexOfShelve < 1) {
                throw new ShleveNotFound(String.format("Данной полки %d нет в шкафу %s", Integer.valueOf(indexOfShelve), this));
            }
            switch (indexOfShelve) {
                case 1:
                    if (this.shelve1.size() >= 5) {
                        throw new ShelveOutOfSpace("Место на полке 1 кончилось");
                    }
                    this.shelve1.add(obj);
                    return;
                case 2:
                    if (this.shelve2.size() >= 5) {
                        throw new ShelveOutOfSpace("Место на полке 2 кончилось");
                    }
                    this.shelve2.add(obj);
                    return;
                case 3:
                    if (this.shelve3.size() >= 5) {
                        throw new ShelveOutOfSpace("Место на полке 3 кончилось");
                    }
                    this.shelve3.add(obj);
                    return;
                case 4:
                    if (this.shelve4.size() >= 5) {
                        throw new ShelveOutOfSpace("Место на полке 4 кончилось");
                    }
                    this.shelve4.add(obj);
                    return;
                default:
                    throw new ShleveNotFound(String.format("Данной полки %d нет в шкафу %s", Integer.valueOf(indexOfShelve), obj));
            }
        }
    }
}