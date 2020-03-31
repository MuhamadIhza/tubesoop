public class Zombie1 extends Zombie{

    private static int life = 50;
    public static int speed = 1;
    private final static int damage = 4;
    //public final static char present = 'z';
    
    public Zombie1(){
        super();
        super.present = 'z';
        super.speed = Zombie1.speed;
        super.life = Zombie1.life;
    }


}