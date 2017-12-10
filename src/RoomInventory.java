import java.util.Iterator;

public class RoomInventory{
    String[] items;

    public RoomInventory(String[] items){
        this.items = items;
    }

    public Iterator createIterator() {
        return new RoomInventoryIterator(items);
    }
}
