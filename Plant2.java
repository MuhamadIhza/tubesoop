public class Plant2 extends Plant{

    private  static int life = 60;
    public final static int damage =100;
    public Peluru peluru = new Peluru(Plant2.damage);
    public final static char present = 'P';
    public static int price = 30;
    public static int excudeinterval = 3;
    
    public Plant2(){
        super();
        this.peluru.damage = Plant2.damage;
        this.peluru.setIndexY(this.getIndexY());
        this.peluru.setIndexX(this.getIndexX() + 1);
    }

    public void setPeluruIndex(){
        this.peluru.setIndexY(this.getIndexY());
        this.peluru.setIndexX(this.getIndexX() + 1);
    }


}