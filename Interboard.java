import java.io.IOException;
import java.util.Random; 
import java.util.Scanner;

public class Interboard {

    public final static int HORIZONTAL_MAT = 25;
    public final static int VERTICAL_MAT = 7;
    public final static int O_HORIZONTAL_MAT = HORIZONTAL_MAT+2;
    public final static int O_VERTICAL_MAT = VERTICAL_MAT+2;

    public char[][] matrix = new char[VERTICAL_MAT][HORIZONTAL_MAT];
    public Zombie[][] matrixZ = new Zombie[VERTICAL_MAT][HORIZONTAL_MAT];
    public Plant[][] matrixP = new Plant[VERTICAL_MAT][HORIZONTAL_MAT];
    public Peluru[][] matrixPel = new Peluru[VERTICAL_MAT][HORIZONTAL_MAT];
    Random rand = new Random(); 

    //1
    public void initialBoard(){
        final int level=1; //1..O_VERTICAL_MAT

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
        catch(final Exception e){
            System.out.println(e);
        }
    }

    //3
    public void moveZombie(final Zombie z){
        z.moveToLeft();
        vanishAfterMove(z);
        zombieToMats(z);
    }

    //4
    //public void skip(); //connect moveZombie

    //5
    public void printMatrix(){
        final int level=1; //1..O_VERTICAL_MAT

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
                final Zombie1 z1 = new Zombie1();
                zombieToMats(z1);
            }
            else if ((zom%2) == 0){
                final Zombie2 z2 = new Zombie2();
                zombieToMats(z2);
            }
        }
    }

    public void moveAllZombie(){ //connect moveZombie
        for(int i=0; i <= Definer.VERTICAL_MAT-1; i++){
            for(int j=0; j <= Definer.HORIZONTAL_MAT-1; j++){                   
                char test = matrix[i][j];
                if ((Character.compare(test, 'z') == 0) || (Character.compare(test, 'Z') == 0)){
                    if (matrixZ[i][j].life <= 0){ //nyawa abis
                        matrixZ[i][j] = null;
                        matrix[i][j] = ' ';
                    }
                    else{ //normal
                        moveZombie(this.matrixZ[i][j]);
                    }
                }               
            }
        }
    }


    //7
    public void zombieToMatrix(final Zombie z){
        matrix[z.getIndexY()-1][z.getIndexX()-1] = z.present;
    }

    //8 
    public void zombieToMatrixZ(final Zombie z){
        matrixZ[z.getIndexY()-1][z.getIndexX()-1] = z;
    }

    public void plantToMatrix(final Plant1 p){
        matrix[p.getIndexY()-1][p.getIndexX()-1] = p.present;
    }

    public void plantToMatrixP(final Plant1 p){
        matrixP[p.getIndexY()-1][p.getIndexX()-1] = p;
    }

    public void plantToMats(final Plant1 p){
        plantToMatrixP(p);
        plantToMatrix(p);
    }

    public void plantToMatrix(final Plant2 p){
        matrix[p.getIndexY()-1][p.getIndexX()-1] = p.present;
    }

    public void plantToMatrixP(final Plant2 p){
        matrixP[p.getIndexY()-1][p.getIndexX()-1] = p;
    }

    public void plantToMats(final Plant2 p){
        plantToMatrixP(p);
        plantToMatrix(p);
    }
    
    public void peluruToMatrix(final Peluru pel){
        matrix[pel.getIndexY()-1][pel.getIndexX()-1] = pel.present;
     }
 
     //6
     public void peluruToMatrixPel(final Peluru pel){
         matrixPel[pel.getIndexY()-1][pel.getIndexX()-1] = pel;
     }
 
     //7
     public void peluruToMats(final Peluru pel){
         peluruToMatrixPel(pel);
         peluruToMatrix(pel);
     }


     public void moveAllPel(){ //connect moveZombie, mungkin disini bug  //kl touch zombie, null

        for(int i=Definer.VERTICAL_MAT-1; i >= 0; i--){
            for(int j=Definer.HORIZONTAL_MAT-1; j >= 0 ; j--){                   
                final char test = matrix[i][j];
                if ((Character.compare(test, Peluru.present) == 0)){
                    if ((Character.compare(matrix[i][j+2],'z') == 0) || (Character.compare(matrix[i][j+1],'z') == 0) || (Character.compare(matrix[i][j+2],'Z') == 0) || (Character.compare(matrix[i][j+1],'Z') == 0)) { //will touch zombie, null
                        matrix[i][j] = ' ';
                        matrixZ[i][j] = null;
                    }
                    
                    if (j < ) {

                    }
                    else { //fine2 aja
                        movePeluru(this.matrixPel[i][j]);
                    }
                }               
            }
        }
    }

    //9
    public void vanishPelAfterMove(final Peluru pel){
        matrix[pel.getIndexY()-1][pel.getIndexX()-1-1] = ' ';
        matrixPel[pel.getIndexY()-1][pel.getIndexX()-1-1] = null;
        
    }

    //10
    public void movePeluru(final Peluru pel){
        pel.moveToRight();
        vanishPelAfterMove(pel);
        peluruToMats(pel);
    }

    //9
    public void zombieToMats(final Zombie z){
        zombieToMatrixZ(z);
        zombieToMatrix(z);
    }

    //10
    public void vanishAfterMove(final Zombie z){
        matrix[z.getIndexY()-1][z.getIndexX()-1+z.speed] = ' ';
        matrixZ[z.getIndexY()-1][z.getIndexX()-1+z.speed] = null;
    }

    //11
    public void buyPlant(){
        Scanner input = new Scanner(System.in);
        System.out.println("Available plant: ");
        System.out.print("[1] Plant1 damage X price X");
        System.out.println("    [2] Plant2 damage X price X");
        System.out.println("Choose your plant: ");
                
        int jenis = input.nextInt();

        if ((jenis != 1) && (jenis != 2)){
            while ((jenis != 1) && (jenis != 2)){
                System.out.println("Tanaman dengan nomor " + jenis + " tidak tersedia.");
                System.out.println("Choose your plant: ");
                jenis = input.nextInt();
            }
        }

        if (jenis == 1) {
            System.out.println("Enter position of the plant: ");
            final int x = input.nextInt();
            final int y = input.nextInt();
            final Plant1 p = new Plant1();
            p.setLoc(x, y);
            p.setPeluruIndex();
            plantToMats(p);
            peluruToMats(p.peluru);
            printMatrix();
                    //ex.movePeluru(p.peluru);
        } 
        else if (jenis == 2) {
            System.out.println("Enter position of the plant: ");
            final int x = input.nextInt();
            final int y = input.nextInt();
            final Plant2 p2 = new Plant2();
            p2.setLoc(x, y);
            p2.setPeluruIndex();
            plantToMats(p2);
            peluruToMats(p2.peluru);
            printMatrix();
        }
    }

    //12
    public boolean zombieReachEnd(){
        boolean foundEnd = false;
        for (int i=0; i <= Definer.VERTICAL_MAT-1 ; i++){
            if ((Character.compare(matrix[i][1],'Z') == 0) || ((Character.compare(matrix[i][0], 'Z') == 0))){
                foundEnd = true;
            }
            else if (Character.compare(matrix[i][0], 'z') == 0){
                foundEnd = true;
            }
        }

        return foundEnd;
    }

    //13
    //public int finalLocZombie(Zombie Z){ }

    //14
    //public boolean isZombieExist(){}

    //15
    //public 

    //16
    public void zombieDie(){
        for (int i=0; i <= Definer.VERTICAL_MAT-1; i++){
            for (int j=0; j <= Definer.HORIZONTAL_MAT-1; j++){
                if (matrixZ[i][j].life <= 0){
                    matrixZ[i][j] = null;
                    matrix[i][j] = ' ';
                }
            }
        }
    }

    //17
    public void zombiesReceiveAttack(){
        for (int i=0; i <= Definer.VERTICAL_MAT-1; i++){
            for (int j=0; j <= Definer.HORIZONTAL_MAT-1; j++){
                if ((Character.compare(matrix[i][j],'z') == 0) || (Character.compare(matrix[i][j],'Z') == 0)){
                    if ((Character.compare(matrix[i][j-2],'-') == 0) && (j>2)){
                        matrixZ[i][j].receiveAttack(matrixPel[i][j-2]);
                        matrix[i][j-2] = ' ';
                        matrixPel[i][j-2] = null;
                    }
                    else if ((Character.compare(matrix[i][j-1],'-') == 0) && (j>1)){
                        matrixZ[i][j].receiveAttack(matrixPel[i][j-1]);
                        matrix[i][j-1] = ' ';
                        matrixPel[i][j-1] = null;
                    }
                }
            }
        }
    }


    public static void main(final String[] args){
        final Interboard ex = new Interboard();
        //ex.initialBoard();

        //ex.clearScreen();

      //  ex.callZombie();
        //ex.printMatrix();


        final Scanner input = new Scanner(System.in);

        System.out.println("Masukkan command: ");
        String command = input.next();
        
        while ((!command.equals("buy")) && (!command.equals("skip")) && (!command.equals("end"))){
            System.out.println("Command Anda salah, pastikan command 'buy' atau 'skip' atau 'end'!");
            System.out.println("Masukkan command: ");
            command = input.next();
        }

        boolean kalah = false;

        while ((command.equals("buy") || command.equals("skip") || command.equals("end")) && (kalah == false)){
            if (command.equals("buy")){
                final int x,y;
                boolean check;
                check = false;
                ex.printMatrix();
                
                ex.buyPlant();
                System.out.println("Masukkan command: ");
                command = input.next();
                while (!command.equals("buy") && !command.equals("skip") && !command.equals("end")){
                    System.out.println("Command Anda salah, pastikan command 'buy' atau 'skip' atau 'end'!");
                    System.out.println("Masukkan command: ");
                    command = input.next();
                }
        
            }
            else if (command.equals("skip")){
                ex.moveAllZombie();

                ex.callZombie();
                
                ex.moveAllPel();
                ex.zombiesReceiveAttack();

                
                ex.printMatrix();
                for (int i=0; i <= Definer.VERTICAL_MAT-1; i++){ //test cek peluru damagenya brp
                    for (int j=0; j <= Definer.HORIZONTAL_MAT-1; j++){
                        if (Character.compare(ex.matrix[i][j],'-') == 0){
                            System.out.println(i+ " " + j+ " " + ex.matrixPel[i][j].damage);
                        }
                        else if ((Character.compare(ex.matrix[i][j],'z') == 0) || (Character.compare(ex.matrix[i][j],'Z') == 0)){
                            System.out.println(i+ " " + j+ " " + ex.matrixZ[i][j].life);
                        }
                    }
                }

                if (ex.zombieReachEnd() == true){
                    kalah = true;
                }
                else{
                    System.out.println("Masukkan command: ");
                    command = input.next();
                    //ex.moveAllPel();
                    while (!command.equals("buy") && !command.equals("skip") && !command.equals("end")){
                        System.out.println("Command Anda salah, pastikan command 'buy' atau 'skip' atau 'end'!");
                        System.out.println("Masukkan command: ");
                        command = input.next();
                    }
                }

                
                
            }
            
        }

        if (kalah == true){
            System.out.println("Anda kalah, otak Anda dimakan Zombie. Permainan usai.");
        }
    }
}