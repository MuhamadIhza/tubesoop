import java.util.Random;

public class Zombie {

    Random rand = new Random();

    public final static int HORIZONTAL_MAT = 25;
    public final static int VERTICAL_MAT = 7;

    public final static int damage = 10;
    private int life;
    public final static char present = 'Z';
    public static int speed = 1; // in case it decreases when it receives an attack
    private int indexY;
    private int indexX;
    private int hitAmount; // show how much the zombie has hit in order to determine the decrease of its
                           // speed

    public Zombie() {
        this.setIndexX(HORIZONTAL_MAT);
        randomizeStartLoc();
    }

    public int getIndexX() {
        return indexX;
    }

    public void setIndexX(int indexX) {
        this.indexX = indexX;
    }

    public int getIndexY() {
        return indexY;
    }

    public void setIndexY(int indexY) {
        this.indexY = indexY;
    }

    public void receiveAttack(Plant p) {
        this.life -= p.damage;
    }

    // public void attack();

    public void moveToLeft() { // connect to void setLoc
        this.setIndexX(this.getIndexX() - speed);
    }

    // public void randomizeTime();

    public void randomizeStartLoc() {
        int y = rand.nextInt(VERTICAL_MAT);
        if (y==0){
            y += 1;
        }
        this.setIndexY(y);
    }

    public void setLoc(int x, int y) { // X and Y
        this.setIndexX(x);
        this.setIndexY(y);
    }

  //  public void presentZombie();

    public void decreaseZombieSpeed(){ //if its already 1 then its stuck to 1
        if (this.speed > 1){
            this.speed -= 1;
        }
        
    }

  //  public void die();

  


}