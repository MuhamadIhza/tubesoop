public abstract class Plant {
    public final static char present = 'P';
    public final static int damage = 1;
    private int life = 100;
    private int indexY;
    private int indexX;

    //public Plant() {}

    public void setLoc(int x, int y){
        this.indexX = x;
        this.indexY = y;
    }

    //public void attack();

    //public void constantExcude();

    public void receiveAttack(Zombie z){
        this.life -= z.damage;
    }
    
    



}