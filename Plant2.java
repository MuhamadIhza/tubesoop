public class Plant2 extends Plant{

    private  static int life = 60;
    private final static int damage = 6;
    public Peluru peluru = new Peluru(Plant2.damage);
    public final static char present = 'P';
    public static int price = 30;
    
    public Plant2(){
        super();
        this.peluru.setIndexY(this.getIndexY());
        this.peluru.setIndexX(this.getIndexX() + 1);
    }


}