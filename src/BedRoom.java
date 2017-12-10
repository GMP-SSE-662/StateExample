public class BedRoom implements Room{
    GameRunner gameRunner;

    public BedRoom(GameRunner gameRunner){
        this.gameRunner = gameRunner;
    }

    public String describeRoom(){
        return "You wake up at 5 AM after a long night of HARDCORE PARTYING."+
                "\nYou have to be at work in 10 minutes. What do you do?";
    }

    public String putOnClothes(){
        return "You don your most stylish leather jeans, leather jacket and leather jacket." +
                "It's time to drive to work and write some sexy code.";
    }

    public String getInCar(){
        gameRunner.setCurrentRoom(new Car(gameRunner));
        return "You hop in the driver's seat of the world's best car, a 1998 Toyota Camry.";
    }

    public String goToWork(){
        gameRunner.gameOver();
        return "You begin walking to work. After a few minutes of walking you die from exhaustion.";
    }

    public String signIn(){
        return "You can't sign in unless you're at work.";
    }

    public String doWork(){
        return "Unfortunately, you can't work from home.";
    }

    @Override
    public RoomInventory getInventory() {
        return null;
    }
}
