import java.util.ArrayList; 
public class Plant2 extends Plant{

    private  static int life = 60;
    public final static int damage =100;
   // public ArrayList<Peluru> peluru;
    public final static char present = 'P';
    public static int price = 30;
    public static int excudeinterval = 3;
    
    public Plant2(){
        super();
        //peluru = new ArrayList<Peluru>();
        //this.peluru.get(peluru.size()).setIndexY(this.getIndexY());
        //this.peluru.get(peluru.size()).setIndexX(this.getIndexX() + 1);
        //generatePeluru();

        
    }

    //public void setPeluruIndex(){
     //   this.peluru.get(peluru.size()-1).setIndexY(this.getIndexY());
      //  this.peluru.get(peluru.size()-1).setIndexX(this.getIndexX() + 1);
    //}

    //public void generatePeluru(){
     //   Peluru e = new Peluru(Plant2.damage);
      //  super.peluru.add(e);
    //}
}