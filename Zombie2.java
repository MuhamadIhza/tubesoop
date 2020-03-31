public class Zombie2 extends Zombie{

    private static int life = 60;
    public static int speed = 2;
    private final static int damage = 12;
    //public final static char present = 'Z';
    
    public Zombie2(){
        super();
        super.present = 'Z';
        super.speed = Zombie2.speed;
        super.life = Zombie2.life;
        super.damage = Zombie2.damage;
    }
    

}