import java.util.ArrayList;
import java.util.Iterator;

public class PlayerInventory {
    ArrayList<String> items = new ArrayList<>();
    int position = 0;

    public void add(String item){
        items.add(item);
    }

    public Iterator<String> createIterator(){
        return items.iterator();
    }
}
