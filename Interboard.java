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
    public Plant[][] matrixP = new Plant[VERTICAL_MAT][HORIZONTAL_MAT];
    public Peluru[][] matrixPel = new Peluru[VERTICAL_MAT][HORIZONTAL_MAT];
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
    public void callZombie(){
        final int d = rand.nextInt(4);
        final int zom = rand.nextInt(2);
        if ((d% 4) == 2){ //random num to initiate zombie acts as "time"
            if ((zom%2) == 1){
                Zombie1 z1 = new Zombie1();
                zombieToMats(z1);
            }
            else if ((zom%2) == 0){
                Zombie2 z2 = new Zombie2();
                zombieToMats(z2);
            }
        }
    }

    public void moveAllZombie(){ //connect moveZombie
        for(int i=0; i <= Definer.VERTICAL_MAT-1; i++){
            for(int j=0; j <= Definer.HORIZONTAL_MAT-1; j++){                   
                char test = matrix[i][j];
                if ((Character.compare(test, 'z') == 0) || (Character.compare(test, 'Z') == 0)){
                    moveZombie(this.matrixZ[i][j]);
                }               
            }
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

    public void plantToMatrix(Plant1 p){
        matrix[p.getIndexY()-1][p.getIndexX()-1] = p.present;
    }

    public void plantToMatrixP(Plant1 p){
        matrixP[p.getIndexY()-1][p.getIndexX()-1] = p;
    }

    public void plantToMats(Plant1 p){
        plantToMatrixP(p);
        plantToMatrix(p);
    }

    public void plantToMatrix(Plant2 p){
        matrix[p.getIndexY()-1][p.getIndexX()-1] = p.present;
    }

    public void plantToMatrixP(Plant2 p){
        matrixP[p.getIndexY()-1][p.getIndexX()-1] = p;
    }

    public void plantToMats(Plant2 p){
        plantToMatrixP(p);
        plantToMatrix(p);
    }
    
    public void peluruToMatrix(Peluru pel){
        matrix[pel.getIndexY()-1][pel.getIndexX()-1] = pel.present;
     }
 
     //6
     public void peluruToMatrixPel(Peluru pel){
         matrixPel[pel.getIndexY()-1][pel.getIndexX()-1] = pel;
     }
 
     //7
     public void peluruToMats(Peluru pel){
         peluruToMatrixPel(pel);
         peluruToMatrix(pel);
     }


     public void moveAllPel(){ //connect moveZombie, mungkin disini bug
        for(int i=7-1; i >= 0; i--){
            for(int j=25-1; j >= 0 ; j--){                   
                char test = matrix[i][j];
                if ((Character.compare(test, Peluru.present) == 0)){
                    movePeluru(this.matrixPel[i][j]);
                }               
            }
        }
    }

    //9
    public void vanishPelAfterMove(Peluru pel){
        System.out.println(pel.getIndexX());
        System.out.println(pel.getIndexY());
        matrix[pel.getIndexY()-1][pel.getIndexX()-1-1] = ' ';
        matrixPel[pel.getIndexY()-1][pel.getIndexX()-1-1] = null;
        
    }

    //10
    public void movePeluru(Peluru pel){
        pel.moveToRight();
        vanishPelAfterMove(pel);
        peluruToMats(pel);
    }

    //9
    public void zombieToMats(Zombie z){
        zombieToMatrixZ(z);
        zombieToMatrix(z);
    }

    //10
    public void vanishAfterMove(Zombie z){
        matrix[z.getIndexY()-1][z.getIndexX()-1+z.speed] = ' ';
        matrixZ[z.getIndexY()-1][z.getIndexX()-1+z.speed] = null;
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
        Plant1 p;
        Plant2 p2;
        while (command.equals("buy")){
            int x,y;
            boolean check;
            check = false;
            ex.printMatrix();
            System.out.println("Choose your plant: ");
            int jenis = input.nextInt();
            System.out.println("Enter position of the plant: ");
            x = input.nextInt();
            y = input.nextInt();
            if (jenis == 1) {
                p = new Plant1();
                p.setLoc(x, y);
                p.setPeluruIndex();
                ex.plantToMats(p);
                ex.peluruToMats(p.peluru);
                ex.printMatrix();
                //ex.movePeluru(p.peluru);
            } else {
                p2 = new Plant2();
                p2.setLoc(x, y);
                p2.setPeluruIndex();
                ex.plantToMats(p2);
                ex.peluruToMats(p2.peluru);
                ex.printMatrix();
            }
            System.out.println("Masukkan command: ");
            command = input.next();
    
        }
        while (command.equals("skip")){
            ex.callZombie();
            ex.moveAllZombie();
            //ex.moveAllPel();
            //ex.printMatrix();
            //ex.clearScreen();
            //ex.moveZombie(z);
            //ex.printMatrix(); 
            ex.printMatrix();
        
            System.out.println("Masukkan command: ");
            command = input.next();
            ex.moveAllPel();
        }
    }
}