import java.util.ArrayList;

public class Plant1 extends Plant{

    private  static int life = 50;
    public final static int damage = 15;
    
    public final static char present = 'p';
    public static int price = 25;
    public static int excudeinterval = 4;
    //public ArrayList<Peluru> peluru;

    
    public Plant1(){
        super();

        //peluru = new ArrayList<Peluru>();
        //generatePeluru();
        //this.peluru.get(0).setIndexY(super.getIndexY());
        //this.peluru.get(0).setIndexX(super.getIndexX() + 1);
        
    }

    //public void setPeluruIndex(){
      //  this.peluru.get(peluru.size()-1).setIndexY(this.getIndexY());
       // this.peluru.get(peluru.size()-1).setIndexX(this.getIndexX() + 1);
   // }

    //public void generatePeluru(){
      //  Peluru e = new Peluru(Plant1.damage);
       // super.peluru.add(e);
    //}
}