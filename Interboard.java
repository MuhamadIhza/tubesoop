import java.io.IOException;
import java.util.Random; 
import java.util.Scanner;

public class Interboard {

    public final static int HORIZONTAL_MAT = 25;
    public final static int VERTICAL_MAT = 7;
    public final static int O_HORIZONTAL_MAT = HORIZONTAL_MAT+2;
    public final static int O_VERTICAL_MAT = VERTICAL_MAT+2;

    public static char[][] matrix = new char[VERTICAL_MAT][HORIZONTAL_MAT];
    public Zombie[][] matrixZ = new Zombie[VERTICAL_MAT][HORIZONTAL_MAT];

    Random rand = new Random(); 

    //1
    public void initialBoard(){
        int level=1; //1..O_VERTICAL_MAT

        for (int i=0; i <= O_HORIZONTAL_MAT-1; i++){
            System.out.print("*");
        }
        System.out.println("");
        
        for (int j=0; j <= VERTICAL_MAT-1; j++){
            System.out.print("*");
            for (int k=0; k <= HORIZONTAL_MAT-1; k++){
                System.out.print(" "); //INDEX
            }
            System.out.println("*");
        }

        for (int i=0; i <= O_HORIZONTAL_MAT-1; i++){
            System.out.print("*");
        }
        System.out.println("");

    }

    //2
    public void clearScreen(){
        try{
            new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    //3
    public void moveZombie(Zombie z){
        z.moveToLeft();
        vanishAfterMove(z);
        zombieToMats(z);
    }

    //4
    //public void skip(); //connect moveZombie

    //5
    public void printMatrix(){
        int level=1; //1..O_VERTICAL_MAT

        for (int i=0; i <= O_HORIZONTAL_MAT-1; i++){
            System.out.print("*");
        }
        System.out.println("");
        
        for (int j=0; j <= VERTICAL_MAT-1; j++){
            System.out.print("*");
            for (int k=0; k <= HORIZONTAL_MAT-1; k++){
                System.out.print(this.matrix[j][k]); //INDEX
            }
            System.out.println("*");
        }

        for (int i=0; i <= O_HORIZONTAL_MAT-1; i++){
            System.out.print("*");
        }
        System.out.println("");

    }

    //6
    public void callZombie(Zombie z){
        int d = rand.nextInt(4);
        if ((d% 4) == 2){ //random num to initiate zombie acts as "time"
            z = new Zombie();
            zombieToMats(z);
        }
    }

    //7
    public void zombieToMatrix(Zombie z){
        matrix[z.getIndexY()-1][z.getIndexX()-1] = z.present;
    }

    //8
    public void zombieToMatrixZ(Zombie z){
        matrixZ[z.getIndexY()-1][z.getIndexX()-1] = z;
    }

    //9
    public void zombieToMats(Zombie z){
        zombieToMatrixZ(z);
        zombieToMatrix(z);
    }

    //10
    public void vanishAfterMove(Zombie z){
        matrix[z.getIndexY()-1][z.getIndexX()-1+1] = ' ';
        matrixZ[z.getIndexY()-1][z.getIndexX()-1+1] = null;
    }

    public static void main(String[] args){
        Interboard ex = new Interboard();
        //ex.initialBoard();

        //ex.clearScreen();

      //  ex.callZombie();
        //ex.printMatrix();


        Scanner input = new Scanner(System.in);

        System.out.println("Masukkan command: ");
        String command = input.next();

        while (command.equals("skip")){
            Zombie z = new Zombie();
            ex.callZombie(z);
            ex.printMatrix();
            //ex.clearScreen();
            //ex.moveZombie(z);
            //ex.printMatrix();

            for(int i=0; i <= VERTICAL_MAT-1; i++){
                for(int j=0; j <= HORIZONTAL_MAT-1; j++){                   
                    char test = matrix[i][j];
                    if (Character.compare(test, 'Z') == 0){
                        ex.moveZombie(ex.matrixZ[i][j]);
                    }               
                }
            }
            ex.printMatrix();
            System.out.println("Masukkan command: ");
            command = input.next();
        }
    }
}