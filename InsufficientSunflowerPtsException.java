public class InsufficientSunflowerPtsException extends Exception{
    private int input;

    public InsufficientSunflowerPtsException(int input){
        this.input = input;
    };

    public String getMessage(){
        return ("Insufficient Sunflower Points!");
    };
}