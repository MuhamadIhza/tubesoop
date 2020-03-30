public class Plant1 extends Plant{

    private  static int life = 50;
    private final static int damage = 4;
    public Peluru peluru = new Peluru(Plant1.damage);
    public final static char present = 'p';
    public static int price = 25;

    
    public Plant1(){
        super();
        this.peluru.setIndexY(this.getIndexY());
        this.peluru.setIndexX(this.getIndexX() + 1);
    }

    public void setPeluruIndex(){
        this.peluru.setIndexY(this.getIndexY());
        this.peluru.setIndexX(this.getIndexX() + 1);
    }

}