import java.security.interfaces.DSAKeyPairGenerator;
import java.util.Scanner;

public class Main{
    public static void main(final String[] args){
        final Scanner input = new Scanner(System.in);
        Player<String,Integer> highscore = new Player<String,Integer>();
        System.out.println("|***********************|");
        System.out.println("|****WELCOME TO PVZ*****|");
        System.out.println("|What do you want to do?|");
        System.out.println("|New_Game               |");
        System.out.println("|Highscore              |");
        System.out.println("|Exit                   |");
        System.out.println("|***********************|");
        System.out.println("Masukkan command: ");
        String initCommand = input.next();
        boolean stop = false;
        while((initCommand.equals("New_Game") || initCommand.equals("Highscore") || initCommand.equals("Exit")) && !stop){
            if(initCommand.equals("New_Game")){
                final Interboard ex = new Interboard();
                //ex.initialBoard();
    
                //ex.clearScreen();
    
            //  ex.callZombie();
                //ex.printMatrix();
    
                int score = 0;
    
                System.out.println("Masukkan command permainan: ");
                String command = input.next();
                
                while ((!command.equals("buy")) && (!command.equals("skip")) && (!command.equals("end"))){
                    System.out.println("Command Anda salah, pastikan command 'buy' atau 'skip' atau 'end'!");
                    System.out.println("Masukkan command permainan: ");
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
                        System.out.println("Masukkan command permainan: ");
                        command = input.next();
                        while (!command.equals("buy") && !command.equals("skip") && !command.equals("end")){
                            System.out.println("Command Anda salah, pastikan command 'buy' atau 'skip' atau 'end'!");
                            System.out.println("Masukkan command permainan: ");
                            command = input.next();
                        }
                
                    }
                    else if (command.equals("skip")){
                                    
                        
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
                            ex.moveAllZombie();
                            ex.callZombie();
                            ex.printMatrix();
                            ex.zombiesReceiveAttack();
                            ex.moveAllPel();
                            ex.zombiesReceiveAttack();
                            ex.plantsReceiveAttack();
                            ex.printMatrix();
                            System.out.println("Masukkan command permainan: ");
                            command = input.next();
                            //ex.moveAllPel();
                            while (!command.equals("buy") && !command.equals("skip") && !command.equals("end")){
                                System.out.println("Command Anda salah, pastikan command 'buy' atau 'skip' atau 'end'!");
                                System.out.println("Masukkan command permainan: ");
                                command = input.next();
                            }
                        }
                        score++;
                        
                        
                    }
                    
                }
    
                if (kalah == true){
                    System.out.println("Anda kalah, otak Anda dimakan Zombie. Permainan usai.");
                    System.out.println("Masukkan nama pemain: ");
                    String player = input.next();
                    highscore.add(player,score);
                    highscore.printInfo();
                }
                System.out.println("|***********************|");
                System.out.println("|****WELCOME TO PVZ*****|");
                System.out.println("|What do you want to do?|");
                System.out.println("|New Game               |");
                System.out.println("|Highscore              |");
                System.out.println("|Exit                   |");
                System.out.println("|***********************|");
                System.out.println("Masukkan command: ");
                initCommand = input.next();
            }
            else if (initCommand.equals("Highscore")){
                highscore.printInfo();
                System.out.println("|***********************|");
                System.out.println("|****WELCOME TO PVZ*****|");
                System.out.println("|What do you want to do?|");
                System.out.println("|New Game               |");
                System.out.println("|Highscore              |");
                System.out.println("|Exit                   |");
                System.out.println("|***********************|");
                System.out.println("Masukkan command: ");
                initCommand = input.next();
            }
            else if(initCommand.equals("Exit")){
                stop = true;
            }
            else{
                System.out.println("Command salah! Pastikan command New_Game, Highscore, atau Exit!");
                System.out.println("Masukkan command: ");
                initCommand = input.next();
            }
        }
    }
}