public class InvalidInputException extends Exception{
    private int input;

    public InvalidInputException(int input){
        this.input = input;
    };

    public String getMessage(){
        return ("Input salah! Masukkan [1] atau [2]");
    };
}