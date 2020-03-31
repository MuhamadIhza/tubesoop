public class Plant1 extends Plant{

    private  static int life = 50;
    public final static int damage = 100;
    public Peluru peluru = new Peluru(Plant1.damage);
    public final static char present = 'p';
    public static int price = 25;
    public static int excudeinterval = 4;

    
    public Plant1(){
        super();
        this.peluru.damage = Plant1.damage;
        this.peluru.setIndexY(this.getIndexY());
        this.peluru.setIndexX(this.getIndexX() + 1);
    }

    public void setPeluruIndex(){
        this.peluru.setIndexY(this.getIndexY());
        this.peluru.setIndexX(this.getIndexX() + 1);
    }

}