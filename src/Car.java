public class Car implements Room{
    GameRunner gameRunner;
    RoomInventory carItems = new RoomInventory(new String[]{"Glowsticks", "More Glowsticks"});

    public Car(GameRunner gameRunner){
        this.gameRunner = gameRunner;
    }

    @Override
    public String describeRoom() {
        return "The interior of your 1998 Toyota Camry sparkles and shines. You're about to be late to work.";
    }

    public String putOnClothes(){
        return "It's too cramped in here to get dressed";
    }

    public String getInCar(){
        return "Dude, you're already in your car.";
    }

    public String goToWork(){
        gameRunner.setCurrentRoom(new Office(gameRunner));
        return "You start driving to work";
    }

    public String signIn(){
        return "You can't sign in if you're not at work";
    }

    public String doWork(){
        return "You can't do work if you're not at work";
    }

    @Override
    public RoomInventory getInventory() {
        return carItems;
    }
}
