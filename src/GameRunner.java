import javax.swing.text.html.HTMLDocument;
import java.util.Iterator;
import java.util.Scanner;

public class GameRunner {
    Room currentRoom;
    Scanner textParser = new Scanner(System.in);
    boolean finished;
    PlayerInventory playerInventory = new PlayerInventory();
    RoomInventory roomInventory = null;

    public GameRunner(){
        setCurrentRoom(new BedRoom(this));
        startGame();
    }

    public static void main(String Args[]){
        GameRunner gameRunner = new GameRunner();
    }

    public void setCurrentRoom(Room room){
        this.currentRoom = room;
        this.roomInventory = currentRoom.getInventory();
        System.out.println(currentRoom.describeRoom());
        Iterator playerInventoryIterator = playerInventory.createIterator();
        System.out.println("The room contains: ");
        if(roomInventory != null) {
            Iterator roomInventoryIterator = roomInventory.createIterator();
            printInventory(roomInventoryIterator);
        } else {
            System.out.println("Nothing important");
        }
        System.out.println("You have: ");
        printInventory(playerInventoryIterator);
    }

    void printInventory(Iterator iterator){
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    String getUserInput(){
        return textParser.nextLine();
    }

    public void startGame(){
        String userCommand = "";

        while(!finished){
            userCommand = getUserInput();

            if(userCommand.toLowerCase().contains("get dressed")){
                System.out.println(currentRoom.putOnClothes());
            }
            else if(userCommand.toLowerCase().contains("car")){
                System.out.println(currentRoom.getInCar());
            }
            else if(userCommand.toLowerCase().contains("work")){
                System.out.println(currentRoom.goToWork());
            }
            else if(userCommand.toLowerCase().contains("sign")){
                System.out.println(currentRoom.signIn());
            }
            else if(userCommand.toLowerCase().contains("write")){
                System.out.println(currentRoom.doWork());
            }
            else if(userCommand.toLowerCase().contains("take")){
                if(roomInventory != null) {
                    System.out.println("You take everything");
                    Iterator roomInventoryIterator = roomInventory.createIterator();
                    while (roomInventoryIterator.hasNext()) {
                        playerInventory.add((String) roomInventoryIterator.next());
                        roomInventoryIterator.remove();
                    }
                } else {
                    System.out.println("There is nothing to take.");
                }
            }
            else if(userCommand.toLowerCase().contains("inventory")){
                Iterator playerInventoryIterator = playerInventory.createIterator();
                System.out.println("You have: ");
                printInventory(playerInventoryIterator);
            }
        }
    }

    public void gameOver(){
        finished = true;
    }
}
