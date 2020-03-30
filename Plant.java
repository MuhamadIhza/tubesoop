public abstract class Plant {
    //public final static char present = 'P';
    //public final static int damage = 1;
    //private int life = 100;
    private int indexY;
    private int indexX;
    public Peluru peluru;

    public Plant() {
    }

    public void setLoc(int x, int y){
        this.indexX = x;
        this.indexY = y;
    }


    public void attack(){
        
    }


    /**public void setlife(int life){
        this.life = life;
    }
    public int getlife(){
        return this.life;
    } **/

    public int getIndexX(){
        return indexX;
    }

    public void setIndexX(int x){
        this.indexX = x;
    }

    public int getIndexY(){
        return indexY;
    }

    public void setIndexY(int y){
        this.indexY = y;
    }


    //public void constantExcude();

    public void receiveAttack(Zombie z){
        //this.life -= z.damage;
    }
}