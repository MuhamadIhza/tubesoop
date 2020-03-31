public class Player{
    private int sunflowerPts;
    private static int turn = 0;

    public Player(){
        sunflowerPts = 5000;
        Player.turn++;
    }

    public int getSunflowerPts(){
        return sunflowerPts;
    }
    public void setSunflowerPts(int sunflowerPts){
        this.sunflowerPts = sunflowerPts;
    }

    public void buy(int price){
        sunflowerPts -= price;
    }
    
    public void addSunflowerPts(){
        Player.turn++;
        sunflowerPts += 1010 - Player.turn*10;
    }
}