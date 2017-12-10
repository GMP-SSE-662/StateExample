import java.util.Iterator;

public class RoomInventoryIterator implements Iterator {
    String[] items;
    int position = 0;

    public RoomInventoryIterator(String[] items){
        this.items = items;
    }

    public void remove(){
        if (position <= 0){
            throw new IllegalStateException("You can't remove an item until you've done at least one next()");
        }
        if (items[position-1] != null){
            for (int i = position - 1; i < (items.length - 1); i++){
                items[i] = items[i + 1];
            }
            items[items.length - 1] = null;
            position--;
        }
    }

    public String next(){
        String item = items[position];
        position++;
        return item;
    }

    public boolean hasNext(){
        if(position >= items.length || items[position] == null){
            return false;
        } else {
            return true;
        }
    }
}
