public class Peluru {
    public static char present = '-';
    private int indexX;
    private int indexY;
    public int damage;
    public int speed = 1;

    public Peluru(int damage) {
        this.damage = damage;
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

    public void moveToRight(){
        this.setIndexX(indexX + 1);
    }
}