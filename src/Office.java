import java.util.Scanner;

public class Office implements Room{
    GameRunner gameRunner;
    Scanner textParser = new Scanner(System.in);

    public Office(GameRunner gameRunner){
        this.gameRunner = gameRunner;
    }

    public String describeRoom(){
        return "You're at work. Time to write some requirements.";
    }

    public String putOnClothes(){
        return "You can't get dressed at work";
    }

    public String getInCar(){
        gameRunner.setCurrentRoom(new Car(gameRunner));
        return "Work's for chumps. Time to PARTAYY.";
    }

    public String goToWork(){
        return "You're already here.";
    }

    public String signIn(){
        Constants.signIn();
        return "You sign your timesheet.";
    }

    public String doWork(){
        if(!Constants.isDressed()){
            gameRunner.gameOver();
            return ("Your coworkers scream in anguish.\n" +
                    "The sight of your naked form proves too much for them to bear.\n" +
                    "You are sent to prison and never party again.\n");
        }

        else if (!Constants.isSignedIn()){
            gameRunner.gameOver();
            return ("Tyson, you're not signed in!\n" +
                    "You're fired! Get outta here!\n" +
                    "You have no money and never get to party gain. :'( \n");
        }

        else {
            Constants.finishWork();
            for (int i = 0; i < 10; i++) {
                System.out.println("Write a requirement.");
                textParser.nextLine();
            }
            return "You finished working.";
        }
    }

    @Override
    public RoomInventory getInventory() {
        return null;
    }
}
